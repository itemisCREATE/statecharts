package org.yakindu.sct.domain.generic.assist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;
import org.yakindu.base.xtext.utils.gmf.proposals.ISemanticModification;
import org.yakindu.sct.ui.editor.editor.proposals.AddCompositeModification;
import org.yakindu.sct.ui.editor.editor.proposals.AddOutgoingStateModification;
import org.yakindu.sct.ui.editor.proposals.IEditProposal;
import org.yakindu.sct.ui.editor.proposals.IEditProposalProvider;


public class SCTSmartEditProposalProvider implements IEditProposalProvider {

	@Override
	public List<IEditProposal> getProposals(View view) {
		List<IEditProposal> proposals = new ArrayList<IEditProposal>();

		proposals.add(new ModificationWrappingEditProposal(new AddOutgoingStateModification(view), "Add outgoing state", "Adds a new outgoing transition to a new sibling state." , null));
		proposals.add(new ModificationWrappingEditProposal(new AddCompositeModification(view), "Add sub region", "Adds a new region to this state. This region includes an initial state.", null));
		
		return proposals;
	}
	
	
	
	public static class ModificationWrappingEditProposal implements IEditProposal {

		protected ISemanticModification modification;
		protected String label;
		protected String description;
		protected Image image;
		

		public ModificationWrappingEditProposal(ISemanticModification	modification) {
			this(modification, null, null, null);
		}

		
		public ModificationWrappingEditProposal(ISemanticModification	modification, String label, String description, Image image) {
			this.modification = modification;
			this.label = label;
			this.description = description;
			this.image = image;
		}
		
		

		public String getLabel() {
			return label;
		}



		public void setLabel(String label) {
			this.label = label;
		}



		public String getDescription() {
			return description;
		}



		public void setDescription(String description) {
			this.description = description;
		}


		public Image getImage() {
			return image;
		}


		public void setImage(Image image) {
			this.image = image;
		}


		@Override
		public boolean isApplicable() {
			return modification != null && modification.isApplicable();
		}

		
		

		@Override
		public void apply() {
			if (modification != null) modification.modify();
		}


		@Override
		public String getId() {
			return (modification != null) ? modification.getClass().getName() : null;
		}
		

		
		@Override
		public int getOrder() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}

}

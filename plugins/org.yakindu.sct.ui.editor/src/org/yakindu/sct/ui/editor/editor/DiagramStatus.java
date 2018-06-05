package org.yakindu.sct.ui.editor.editor;

import org.yakindu.sct.domain.extension.DomainStatus;

public class DiagramStatus extends DomainStatus {

		public DiagramStatus(Severity status) {
			super(status);
			
		}
		public DiagramStatus(Severity status, String message) {
			super(status, message);
		}
		public DiagramStatus(Severity status, String message, String shortMessage) {
			super(status, message, shortMessage);
		}

	}
import org.junit.Test;

/**
 * Custom test to test the Naming features as defined in model.naming.sgen.
 *
 */
public class NamingTest {
	
	@Test
	public void testDefaultNaming() {
		IDeclarations sm = new Declarations();
	}
	
	@Test
	public void testPackageNaming() {
		org.yakindu.scr.naming.api.IDeclarations sm = new org.yakindu.scr.naming.base.Declarations();
		org.yakindu.scr.naming.lib.IStatemachine sm2 = new org.yakindu.scr.naming.base.Declarations();
	}
	
	@Test
	public void testTypeNaming() {
		ICustomName sm = new CustomName();
	}
}

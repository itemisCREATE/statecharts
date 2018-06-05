package org.yakindu.sct.ui.editor.editor.themes;

public class ThemeProvider {
	protected static ThemeProvider instance;

	private IStatechartsTheme theme;

	private ThemeProvider() {

	}

	public static ThemeProvider getInstance() {
		if (instance == null) {
			instance = new ThemeProvider();
		}

		return instance;
	}

	public IStatechartsTheme getTheme() {
		return theme;
	}

	public void setTheme(IStatechartsTheme theme) {
		this.theme = theme;
	}
}

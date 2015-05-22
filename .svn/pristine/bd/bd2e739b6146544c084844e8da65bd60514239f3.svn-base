package com.floreantpos.config.ui;

import com.floreantpos.config.AppConfig;
import com.floreantpos.main.Application;
import com.floreantpos.swing.POSTextArea;
import com.floreantpos.swing.POSTextField;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BannerConfigurationView extends ConfigurationView implements ActionListener {

	private POSTextField bannerDelay;
	private POSTextArea bannerField;
	private JLabel bannerLabel;

	public BannerConfigurationView() throws HeadlessException {
		super();
		initUI();

	}

	protected void initUI() {
		setLayout(new MigLayout("fill", "[][grow,fill]", "[][][][][][][][grow,fill]"));
        bannerField = new POSTextArea();
        bannerDelay = new POSTextField("");

        bannerLabel = new JLabel("Banner :"); //$NON-NLS-1$ //$NON-NLS-2$
		add(bannerLabel);
		add(bannerField, "grow, wrap"); //$NON-NLS-1$

        addRow("Delay Banner (millisencond)",bannerDelay);

	}

    public boolean save() throws Exception {

        String bannerTxt = bannerField.getText();

        Application.getInstance().setSystemInitialized(false);

        saveConfig(bannerTxt,bannerDelay.getText());

        return true;

    }

	public void actionPerformed(ActionEvent e) {

		String bannerTxt = bannerField.getText();
		String delay = bannerDelay.getText();

        Application.getInstance().setSystemInitialized(false);

        saveConfig(bannerTxt,delay);

	}

	private void saveConfig(String banner, String delay) {
		AppConfig.setBanner(banner);
        AppConfig.setBannerDelay(delay);
	}

	@Override
	public void initialize() throws Exception {

		String banner = AppConfig.getBanner();

		bannerField.setText(banner);
		bannerDelay.setText(AppConfig.getBannerDelay());

		setInitialized(true);
	}

	@Override
	public String getName() {
		return "Banner";
	}

}

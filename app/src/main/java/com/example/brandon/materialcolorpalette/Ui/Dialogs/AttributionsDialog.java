package com.example.brandon.materialcolorpalette.Ui.Dialogs;

import android.content.Context;

import de.psdev.licensesdialog.LicensesDialog;
import de.psdev.licensesdialog.licenses.ApacheSoftwareLicense20;
import de.psdev.licensesdialog.licenses.License;
import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;

/**
 * Created by Brandon on 4/19/2017.
 * Class for displaying the licenses and attributions dialog
 */

public class AttributionsDialog {

    public static void showLicensesDialog(Context context) {

        Notices notices = new Notices();

        notices.addNotice(getLicenseDialogNotice());
        notices.addNotice(getGoogleIconsNotice());
        notices.addNotice(getGsonNotice());

        new LicensesDialog.Builder(context)
                .setNotices(notices)
                .build()
                .show();
    }

    private static Notice getLicenseDialogNotice() {
        final String name = "LicensesDialog";
        final String url = "http://psdev.de";
        final String copyright = "Copyright 2013 Philip Schiffer <admin@psdev.de>";
        final License license = new ApacheSoftwareLicense20();
        return new Notice(name, url, copyright, license);
    }

    private static Notice getGsonNotice() {
        final String name = "Gson";
        final String url = "https://github.com/google/gson";
        final String copyright = "Copyright 2008 Google Inc.";
        final License license = new ApacheSoftwareLicense20();
        return new Notice(name, url, copyright, license);
    }

    private static Notice getGoogleIconsNotice() {
        final String name = "Google Material Icons";
        final String url = "https://material.io/icons/";
        final License license = new ApacheSoftwareLicense20();
        return new Notice(name, url, null, license);
    }

}
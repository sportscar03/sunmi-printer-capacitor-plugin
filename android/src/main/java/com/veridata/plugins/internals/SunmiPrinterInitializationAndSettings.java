package com.veridata.plugins.internals;

import android.os.RemoteException;

import com.sunmi.peripheral.printer.SunmiPrinterService;

import com.veridata.plugins.SunmiCallbackHelper;
import com.veridata.plugins.SunmiPrintServiceConnector;

public class SunmiPrinterInitializationAndSettings {
    private final SunmiPrintServiceConnector connector;
    private final SunmiCallbackHelper callbackHelper;

    public SunmiPrinterInitializationAndSettings(SunmiPrintServiceConnector connector, SunmiCallbackHelper callbackHelper) {
        this.connector = connector;
        this.callbackHelper = callbackHelper;
    }

    /**
     *  Initialize the printer
     *  All style settings will be restored to default
     */
    public void printerInit(SunmiCallbackHelper.Callback callback) throws RuntimeException {
        SunmiPrinterService service = connector.getService();
        if(service == null) {
            throw new RuntimeException("Printer service is not initialized");
        }

        try {
            service.printerInit(callback.getInnerResultCallback());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void printerSelfChecking(SunmiCallbackHelper.Callback callback) throws RuntimeException {
        SunmiPrinterService service = connector.getService();
        if(service == null) {
            throw new RuntimeException("Printer service is not initialized");
        }

        try {
            service.printerSelfChecking(callback.getInnerResultCallback());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}

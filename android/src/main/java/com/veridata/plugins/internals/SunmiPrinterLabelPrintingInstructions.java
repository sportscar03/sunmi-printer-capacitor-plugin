package com.veridata.plugins.internals;

import android.os.RemoteException;

import com.sunmi.peripheral.printer.SunmiPrinterService;

import com.veridata.plugins.SunmiCallbackHelper;
import com.veridata.plugins.SunmiPrintServiceConnector;

public class SunmiPrinterLabelPrintingInstructions {
    private final SunmiPrintServiceConnector connector;
    private final SunmiCallbackHelper callbackHelper;

    public SunmiPrinterLabelPrintingInstructions(SunmiPrintServiceConnector connector, SunmiCallbackHelper callbackHelper) {
        this.connector = connector;
        this.callbackHelper = callbackHelper;
    }

    public void labelLocate() throws RuntimeException {
        SunmiPrinterService service = connector.getService();
        if(service == null) {
            throw new RuntimeException("Printer service is not initialized");
        }

        try {
            service.labelLocate();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void labelOutput() throws RuntimeException {
        SunmiPrinterService service = connector.getService();
        if(service == null) {
            throw new RuntimeException("Printer service is not initialized");
        }

        try {
            service.labelOutput();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.philips.cn.hr.pps.writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.LineCallbackHandler;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by kevin on 2015/1/20.
 */
public class DefaultHeaderCallback implements  FlatFileHeaderCallback {

    public static final String DEFAULT_HEADER="companyCode,costCenter,personalSubArea,annualIncentive,holiday,laborUnion";


    @Override
    public void writeHeader(Writer writer) throws IOException {
        writer.write(DEFAULT_HEADER);
    }
}

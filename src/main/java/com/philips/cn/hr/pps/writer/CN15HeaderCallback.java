package com.philips.cn.hr.pps.writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by kvn on 2/12/15.
 */
public class CN15HeaderCallback implements FlatFileHeaderCallback {

    public static final String DEFAULT_HEADER="companyCode,costCenter,personalSubArea,annualIncentive,holiday,laborUnion,salesIncentive";

    @Override
    public void writeHeader(Writer writer) throws IOException {
        writer.write(DEFAULT_HEADER);
    }
}

package com.philips.cn.hr.pps.writer;


import com.philips.cn.hr.pps.domain.GenericOutput;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by kvn on 1/14/15.
 */
public class FlatFileWriterWithPrefix extends FlatFileItemWriter implements
        FlatFileFooterCallback, FlatFileHeaderCallback, ItemStream {

    public String getFileNamePrefix() {
        return fileNamePrefix;
    }

    public void setFileNamePrefix(String fileNamePrefix) {
        this.fileNamePrefix = fileNamePrefix;
    }

    private String fileNamePrefix;

    public static final String TODAY=new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    public static final String HEADER_LINE="companyCode,costCenter,personalSubArea,annualIncentive,holiday,laborUnion";



    @Override
    public void setResource(Resource resource) {
        super.setResource(resource);
    }

    @Override
    public void writeFooter(Writer writer) throws IOException {

    }

    @Override
    public void writeHeader(Writer writer) throws IOException {

    }


//    private String fileNamePrefix;
//
//    private String dir="c:/tmp/";

//
//    public FlatFileWriterWithPreDefinedName(String fileNamePrefix) {
//        this(new FlatFileItemWriter<O>(),fileNamePrefix);
//    }
//
//    public FlatFileWriterWithPreDefinedName(FlatFileItemWriter<O> delegate, String fileNamePrefix) {
//        this.delegate = delegate;
//        this.fileNamePrefix = fileNamePrefix;
//        this.delegate.setResource(new FileSystemResource(dir+fileNamePrefix+"_xxxx.csv"));
////        this.delegate.setShouldDeleteIfExists(true);
////        this.delegate.setShouldDeleteIfEmpty(true);
//        this.delegate.setLineAggregator(new PassThroughLineAggregator());
//        this.delegate.open(new ExecutionContext());
//
//
//    }
}

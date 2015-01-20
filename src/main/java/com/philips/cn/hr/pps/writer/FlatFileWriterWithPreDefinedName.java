package com.philips.cn.hr.pps.writer;


import com.philips.cn.hr.pps.domain.GenericOutput;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Created by kvn on 1/14/15.
 */
public class FlatFileWriterWithPreDefinedName implements ItemWriter<GenericOutput>,
        FlatFileFooterCallback, FlatFileHeaderCallback, ItemStream {

    private FlatFileItemWriter<GenericOutput> delegate;


    @Override
    public void writeHeader(Writer writer) throws IOException {

    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        this.delegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        this.delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        this.delegate.close();
    }

    @Override
    public void writeFooter(Writer writer) throws IOException {
        //noop;
    }

    @Override
    public void write(List<? extends GenericOutput> list) throws Exception {

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

package com.philips.cn.hr.pps.writer;


import com.philips.cn.hr.pps.domain.CombinedOutput;
import com.philips.cn.hr.pps.domain.GenericOutput;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class XCompositeItemWriter<T extends GenericOutput> implements ItemStreamWriter<T>, InitializingBean {

    public static final String TODAY=new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    public String saveAsDestination;

    private Map<String, ItemWriter<T>> delegates = new HashMap<String, ItemWriter<T>>();

    private boolean ignoreItemStream = false;


    public String getSaveAsDestination() {
        return saveAsDestination;
    }

    public void setSaveAsDestination(String saveAsDestination) {
        this.saveAsDestination = saveAsDestination;
    }

    public boolean isIgnoreItemStream() {
        return ignoreItemStream;
    }

    public void setIgnoreItemStream(boolean ignoreItemStream) {
        this.ignoreItemStream = ignoreItemStream;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        for (ItemWriter<T> writer : delegates.values()) {
            if (!ignoreItemStream && (writer instanceof ItemStream)) {
                ((ItemStream) writer).open(executionContext);
            }
        }
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        for (ItemWriter<T> writer : delegates.values()) {
            if (!ignoreItemStream && (writer instanceof ItemStream)) {
                ((ItemStream) writer).update(executionContext);
            }
        }
    }

    @Override
    public void close() throws ItemStreamException {
        for (ItemWriter<T> writer : delegates.values()) {
            if (!ignoreItemStream && (writer instanceof ItemStream)) {
                ((ItemStream) writer).close();
            }
        }
    }


    @Override
    public void write(List<? extends T> ts) throws Exception {
        for(T t : ts){
            ItemWriter<T> itemWriter  = getAssociatedItemWriter(t);
            itemWriter.write(Arrays.asList(t));
        }
    }

    private ItemWriter<T> getAssociatedItemWriter(T t) throws MalformedURLException {
        
        String code = t.getCompanyCode()+"_"+t.getEmployeeType();


        //CN15 ,output sales incentive is required;


        if(t.getCompanyCode().equalsIgnoreCase("CN15")){

        }
        //
        //new delegate;

        FlatFileItemWriter<T> writer = null;

        if(delegates.get(code)==null){

            writer  = new FlatFileItemWriter<T>();

            String resource = saveAsDestination+"/"+code+"_"+TODAY+".csv";

            System.out.println("going to save as "+resource);

            writer.setResource(new UrlResource(resource));

            this.registerDelegate(code,writer);

        } else {
            writer = (FlatFileItemWriter<T>)this.delegates.get(code);
        }

        return writer;
    }

    private void registerDelegate(String code, FlatFileItemWriter<T> writer) {

        if(this.delegates.get(code)==null){

            this.delegates.put(code,writer);

            //and then open the writer;

            writer.setLineAggregator(new PassThroughLineAggregator());

            writer.setHeaderCallback(new DefaultHeaderCallback());

            if (!ignoreItemStream && (writer instanceof ItemStream)) {
                ((ItemStream) writer).open(new ExecutionContext());//something wrong ?
            }
        }
    }

}
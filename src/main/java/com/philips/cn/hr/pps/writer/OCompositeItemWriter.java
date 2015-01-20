package com.philips.cn.hr.pps.writer;


import com.philips.cn.hr.pps.domain.GenericOutput;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by kvn on 1/15/15.
 */
public class OCompositeItemWriter implements ItemStreamWriter<GenericOutput>, InitializingBean {

//    private List<ItemWriter<? super O>> delegates;

    public static final String TODAY=new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    public static final String HEADER_LINE="companyCode,costCenter,personalSubArea,annualIncentive,holiday,laborUnion";

    public String saveAsDestination;

    private Map<String, ItemWriter<? super GenericOutput>> delegates = new HashMap<String, ItemWriter<? super GenericOutput>>();

    private boolean ignoreItemStream = false;

    public String getSaveAsDestination() {
        return saveAsDestination;
    }

    public void setSaveAsDestination(String saveAsDestination) {
        this.saveAsDestination = saveAsDestination;
    }

    public void setIgnoreItemStream(boolean ignoreItemStream) {
        this.ignoreItemStream = ignoreItemStream;
    }

    @Override
    public void write(List<? extends GenericOutput> item) throws Exception {
//        for (ItemWriter<? super T> writer : delegates) {
//            writer.write(item);
//        }

        for(GenericOutput t : item){
            ItemWriter<? super GenericOutput> itemWriter  = getAssociatedItemWriter(t);
            itemWriter.write(Arrays.asList(t));
        }
    }

    private ItemWriter<? super GenericOutput> getAssociatedItemWriter(GenericOutput item) throws MalformedURLException {

        String code = item.getCompanyCode()+"_"+item.getEmployeeType();

        //new delegate;

        FlatFileItemWriter<? super GenericOutput> writer;

        if(delegates.get(code)==null){

            writer  = new FlatFileItemWriter<GenericOutput>();

            String resource = saveAsDestination+"/"+code+"_"+TODAY+".csv";

            System.out.println("going to save as "+resource);

            writer.setResource(new UrlResource(resource));

            this.registerDelegate(code,writer);

        } else {
            writer =(FlatFileItemWriter<? super GenericOutput>)this.delegates.get(code);
        }

//        writer.write();


        return writer;
    }

    private void registerDelegate(String code, FlatFileItemWriter<? super GenericOutput> writer) {
        if(this.delegates.get(code)==null){
            this.delegates.put(code,writer);

            //and then open the writer;

            if (!ignoreItemStream && (writer instanceof ItemStream)) {
                ((ItemStream) writer).open(new ExecutionContext());//something wrong ?
            }

            //and then add the default line Aggregator;

            writer.setLineAggregator(new PassThroughLineAggregator());

            //writer header->hard code at this moment;

//            writer.write(Arrays.asList(HEADER_LINE));


        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        Assert.notNull(delegates, "The 'delegates' may not be null");
//        Assert.notEmpty(delegates, "The 'delegates' may not be empty");
    }

//    public void setDelegates(List<ItemWriter<? super T>> delegates) {
//        this.delegates = delegates;
//    }



    @Override
    public void close() throws ItemStreamException {
        for (ItemWriter<? super GenericOutput> writer : delegates.values()) {
            if (!ignoreItemStream && (writer instanceof ItemStream)) {
                ((ItemStream) writer).close();
            }
        }
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        for (ItemWriter<? super GenericOutput> writer : delegates.values()) {
            if (!ignoreItemStream && (writer instanceof ItemStream)) {
                ((ItemStream) writer).open(executionContext);
            }
        }
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        for (ItemWriter<? super GenericOutput> writer : delegates.values()) {
            if (!ignoreItemStream && (writer instanceof ItemStream)) {
                ((ItemStream) writer).update(executionContext);
            }
        }
    }
}
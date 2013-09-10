package com.testdroid.api;

import java.util.List;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonView;

/**
 *
 * @author kajdus
 */
@XmlRootElement
@JsonIgnoreProperties(value = {"id"})
public class APIList<T extends APIEntity> extends APIEntity {
    private String next;
    private String previous;
    @XmlElementWrapper
    private List<T> data;
    private Integer offset;
    private Integer limit;
    private Integer total;
    private String search;
    private String sort;

    public APIList() {}
    public APIList(String next, String previous, List<T> data, Integer total, String search, String sort) {
        this.next = next;
        this.previous = previous;
        this.data = data;
        this.total = total;
        this.search = search;
        this.sort = sort;
    }
    
    /**
     * Get full URL of the next page of the collection.
     * Simple call it to fetch next items.
     */
    @JsonView(APIView.class)
    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    /**
     * Get full URL of the previous page of the collection.
     * Simple call it to fetch previous items.
     */
    @JsonView(APIView.class)
    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    /**
     * Get found data of the list.
     * List contains only set of items contrained with <code>offset</code>, 
     * <code>limit</code> and <code>search</code>.
     */
    @XmlTransient
    @JsonView(APIView.class)
    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @JsonView(APIView.class)
    public T get(int index) {
        return this.data.get(index);
    }
    
    @JsonView(APIView.class)
    public boolean isEmpty() {
        return this.data.isEmpty();
    }
    
    /**
     * Get offset of data page returned in <code>getData()</code> method.
     */
    @JsonView(APIView.class)
    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * Get limit of data page returned in <code>getData()</code> method.
     */
    @JsonView(APIView.class)
    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * Get total number of items to be returned - independent from paging.
     */
    @JsonView(APIView.class)
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * Get search phrase used during retrieving data returned in <code>getData()</code> method.
     */
    @JsonView(APIView.class)
    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    /**
     * Get serialized sort value used during retrieving data returned in <code>getData()</code> method.
     */
    @JsonView(APIView.class)
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    @JsonView(APIView.class)
    public boolean hasId() {
        return false;
    }

}

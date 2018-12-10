package com.cskaoyan.domain.technologyMonitor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class PageVO {
    @Min(0)
   private Integer page;
    @Min(0)
   private Integer rows;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}

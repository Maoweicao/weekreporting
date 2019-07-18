/*
 * MIT License
 *
 * Copyright (c) 2019 Liu Xin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package cn.liuxin.weekreporting.Model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "Report")
public class Report{

    @GeneratedValue@Id
            @Column(name = "ID")
    long id;
    @CreatedDate
            @Column(name = "CREATEDATE")
            private Date createDate;
    @LastModifiedDate
            @Column(name = "LASTMODIFIEDDATE")
            private Date lastModifiedDate;
    @Column(name = "REPORTTIME")
    String reportTime;
    @Column(name = "REPORTER")
    String reporter;
    @Column(name = "WHATYOUDO")
    String whatyoudo;
    @Column(name = "WHATYOUGET")
    String whatyouget;
    @Column(name = "WHATPROBLEM")
    String whatproblem;
    @Column(name = "WHATYOUNEED")
    String whatyouneed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getWhatyoudo() {
        return whatyoudo;
    }

    public void setWhatyoudo(String whatyoudo) {
        this.whatyoudo = whatyoudo;
    }

    public String getWhatyouget() {
        return whatyouget;
    }

    public void setWhatyouget(String whatyouget) {
        this.whatyouget = whatyouget;
    }

    public String getWhatproblem() {
        return whatproblem;
    }

    public void setWhatproblem(String whatproblem) {
        this.whatproblem = whatproblem;
    }

    public String getWhatyouneed() {
        return whatyouneed;
    }

    public void setWhatyouneed(String whatyouneed) {
        this.whatyouneed = whatyouneed;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}

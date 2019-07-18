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

import cn.liuxin.weekreporting.Util.ReportUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;
import java.text.ParseException;

@Entity
public class ReporterUpTime {

    @Id
    String reporter;
    String reportTime;
    int difftime;

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public int getDifftime() {
        return difftime;
    }

    public void setDifftime(int difftime) {
        this.difftime = difftime;
    }

    public ReporterUpTime(String reporter, String reportTime, int difftime) {
        this.reporter = reporter;
        this.reportTime = reportTime;
        this.difftime = difftime;
    }

    public ReporterUpTime(String reporter, String reportTime)
    {
        this.reporter=reporter;
        this.reportTime=reportTime;
        try {
            this.difftime=ReportUtils.daysBetweenToday(reportTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public ReporterUpTime() {
    }

    public void refreshDiffTime()
    {
        try {
            this.difftime=ReportUtils.daysBetweenToday(reportTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

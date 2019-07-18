/**
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
package cn.liuxin.weekreporting.Controller;

import cn.liuxin.weekreporting.Model.Report;
import cn.liuxin.weekreporting.Model.ReporterUpTime;
import cn.liuxin.weekreporting.Repository.ReportRepository;
import cn.liuxin.weekreporting.Repository.ReporterUpTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReportController {

    @Autowired
    ReportRepository reportRepository;
    @Autowired
    ReporterUpTimeRepository reporterUpTimeRepository;

    @GetMapping("/reporting")
    public String getReportWeb(Model model)
    {
        model.addAttribute("reporting",new Report());
        return "report";
    }

    @PostMapping("/reporting")
    public String reportingSumbit(Report reporting, Model model, BindingResult bindingResult)
    {
        System.out.println(reporting.getId());
        System.out.println(reporting.getReporter());
        System.out.println(reporting.getWhatyoudo());
        System.out.println(reporting.getReportTime().toString());
        System.out.println(bindingResult.getModel().toString());
        model.addAttribute("reporting",reporting);
        reportRepository.save(reporting);
        ReporterUpTime reporterUpTime = new ReporterUpTime(reporting.getReporter(),reporting.getReportTime());
        reporterUpTimeRepository.save(reporterUpTime);
        return "result";
    }

    @GetMapping("/reportList")
    public String reportList(Model model, @RequestParam(value = "start",defaultValue = "0")int start
            ,@RequestParam(value = "size",defaultValue = "10")int size)
    {
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC,"reportTime");
        Pageable pageable = PageRequest.of(start,size,sort);
        Page<Report> reports = reportRepository.findAll(pageable);
        //List<Report> reports = reportRepository.findAll();
        model.addAttribute("reportList",reports);
        return "reportList";
    }

    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    @GetMapping("/reportTime")
    public String reportTimeList(Model model, @RequestParam(value = "start",defaultValue = "0")int start
            ,@RequestParam(value = "size",defaultValue = "10")int size)
    {
        start = start<0?0:start;
        Pageable pageable = PageRequest.of(start,size);
        Page<ReporterUpTime> reports = reporterUpTimeRepository.findAll(pageable);
        for(ReporterUpTime item:reports)
        {
            item.refreshDiffTime();
        }
        model.addAttribute("reportList",reports);
        return "reportTimeList";
    }
}

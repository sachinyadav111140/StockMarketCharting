import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company.service';
import { Company } from 'src/app/models/Company';
import { FormBuilder, Validators } from "@angular/forms";

@Component({
  selector: 'app-user-compare-companies',
  templateUrl: './user-compare-companies.component.html',
  styleUrls: ['./user-compare-companies.component.css']
})

export class UserCompareCompaniesComponent implements OnInit {
  
  dataSource: Object;
  title: string;

  constructor() {
    
    this.title = 'Compare Companies';
    this.dataSource =  {
      chart: {
        //Set the chart caption
        caption: "Countries With Most Oil Reserves [2017-18]",
        //Set the chart subcaption
        subCaption: "In MMbbl = One Million barrels",
        //Set the x-axis name
        xAxisName: "Country",
        //Set the y-axis name
        yAxisName: "Reserves (MMbbl)",
        numberSuffix: "K",
        //Set the theme for your chart
        theme: "fusion"
      },
      // Chart Data - from step 2
      data: [
      //   {
      //     label: "Venezuela",
      //     value: "290"
      //   },
      //   {
      //     label: "Saudi",
      //     value: "260"
      //   },
      //   {
      //     label: "Canada",
      //     value: "180"
      //   },
      //   {
      //     label: "Iran",
      //     value: "140"
      //   },
      //   {
      //     label: "Russia",
      //     value: "115"
      //   },
      //   {
      //     label: "UAE",
      //     value: "100"
      //   },
      //   {
      //     label: "US",
      //     value: "30"
      //   },
      //   {
      //     label: "China",
      //     value: "30"
      //   }
      ]
    };
  }

  ngOnInit(): void {

  }

  onSubmit() {
    // console.log(this.companyForm);
  }

}

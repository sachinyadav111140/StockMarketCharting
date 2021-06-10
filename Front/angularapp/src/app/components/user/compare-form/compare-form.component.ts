import { Component, OnInit } from '@angular/core';
import { CompanyService } from 'src/app/services/company.service';
import { Company } from 'src/app/models/Company';
import { FormBuilder, Validators } from "@angular/forms";
import {FormControl} from '@angular/forms';
import { Observable } from 'rxjs';
import {map, startWith} from 'rxjs/operators';

@Component({
  selector: 'app-compare-form',
  templateUrl: './compare-form.component.html',
  styleUrls: ['./compare-form.component.css']
})
export class CompareFormComponent implements OnInit {

  myControl = new FormControl();
  filteredCompanies!: Observable<Company[]>;
  companies!: Company[];
  // companyForm:any;
  selectedCompany !: Company;

  constructor(private companyService: CompanyService, public fb: FormBuilder) { }

  ngOnInit(): void {
    this.getCompanies();
    // this.companyForm = this.fb.group({
    //   companyList: this.companies
    // })
    this.filteredCompanies = this.myControl.valueChanges
      .pipe(
        startWith(''),
        map(value => {
          this.setSelectedCompany(this.companies?.find(company => company.companyName===value));
          return this._filter(value);
        })
      );
  }

  private _filter(value: string): Company[] {
    const filterValue = value.toLowerCase();
    return this.companies.filter(company => company.companyName.toLowerCase().includes(filterValue));
  }

  setSelectedCompany(value: any){
    if(value) this.selectedCompany = value;
  }

  getCompanies(): void{
    this.companyService.getCompanies().subscribe(Companies => {this.companies=Companies;
      console.log(this.companies)})
  }

  print(e:any){
    console.log(e);
  }
  // changeCompany(e:any){
  //   this.companies.setValue(e.target.value, {
  //     onlySelf: true
  //   })
  // }
  // get companyList() {
  //   return this.companyForm.get('companyList');
  // }
}

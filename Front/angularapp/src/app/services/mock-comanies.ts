import { Company } from '../models/Company';
import { Sector } from '../models/Sector';
import { StockExchange } from '../models/StockExchange';

export const sectors: Sector[]=[{
    id:"1",
    name: "Finance",
    brief:"finance"
  },
  {
    id:"2",
    name: "Tech",
    brief:"technology"
  },{
    id:"3",
    name: "HealthCare",
    brief:"health care services"
  },{
    id:"4",
    name: "Pharmaceuticals",
    brief:"pharma"
  }
  ]    

  export const stockExchanges: StockExchange[]=[{
    id: "1",
    stockExchange:"BSE",
    brief: "Bombay Stock Exchange",
    address: "Mumbai, Maharashtra",
    remarks: "older"
  },
  {
    id: "2",
    stockExchange:"NSE",
    brief: "National Stock Exchange",
    address: "Delhi",
    remarks: "Newer"
  }
  ]    


export const Companies: Company[]=[{
    id:"1",
    companyName: "Apple",
    turnover: 100000000,
    ceo: "Tim Cook",
    boardOFDirectors:["Steve Jobs", "Tim Cook"],
    stockExchanges: [stockExchanges[0], stockExchanges[1]],
    sector: sectors[1],
    stockCode:"APL",
    brief:"trillion dollar comapny"
  },
  {
    id:"2",
    companyName: "Microsoft",
    turnover: 50000000,
    ceo: "Satya Nadela",
    boardOFDirectors:["Satya Nadela", "Bill Gates"],
    stockExchanges:[stockExchanges[0]],
    sector: sectors[1],
    stockCode:"MS",
    brief:"company behind Windows"
  }
  ]    
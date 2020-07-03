import {Component, OnInit} from '@angular/core';
import {TradeService} from '../../service/trade.service';
import {Trade} from '../../common/trade';

@Component({
  selector: 'app-trade-list',
  templateUrl: './trade-list.component.html',
  styleUrls: ['./trade-list.component.css']
})
export class TradeListComponent implements OnInit {

  trades: Trade[];

  constructor(private tradeService: TradeService) {
  }

  ngOnInit() {
    this.listTrades();
  }

  listTrades() {
    this.tradeService.getTradeList().subscribe(
      data => {
        this.trades = data;
      }
    );
  }

}

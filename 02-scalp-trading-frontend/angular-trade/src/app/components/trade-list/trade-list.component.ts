import {Component, OnInit} from '@angular/core';
import {TradeService} from '../../service/trade.service';
import {Trade} from '../../common/trade';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-trade-list',
  templateUrl: './trade-list.component.html',
  styleUrls: ['./trade-list.component.css']
})
export class TradeListComponent implements OnInit {

  trades: Trade[];
  searchMode: boolean;

  constructor(private tradeService: TradeService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listTrades();
  });
}

  listTrades() {

    this.searchMode = this.route.snapshot.paramMap.has('keyword');
    if (this.searchMode) {
      this.handleSearchTrades();
    }
    else {
      this.handleListTrades();
    }
  }

  handleSearchTrades() {
    const theKeyword: string = this.route.snapshot.paramMap('keyword');

    this.tradeService.searchTrades(theKeyword).subscribe(
      data => {
        this.trades = data;
      }
    );
  }

  handleListTrades() {
    this.tradeService.getTradeList().subscribe(

      data => {
        this.trades = data;
      }
    );
  }

}

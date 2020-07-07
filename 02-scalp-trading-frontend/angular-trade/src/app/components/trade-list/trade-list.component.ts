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
  currentUserId: number;

  constructor(private tradeService: TradeService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listTrades();
    });
}

listTrades() {

    const hasUserId: boolean = this.route.snapshot.paramMap.has('id');

    if (hasUserId) {
      // get the id param string and convert string to a number using the + symbol
      this.currentUserId = +this.route.snapshot.paramMap.get('id');
    }
    else {
      // not category id available... default to category id 1
      this.currentUserId = 1;
    }

    // now the products for the given user id
    this.tradeService.getTradeList(this.currentUserId).subscribe(
      data => {
        this.trades = data;
      }
    );
  }

}

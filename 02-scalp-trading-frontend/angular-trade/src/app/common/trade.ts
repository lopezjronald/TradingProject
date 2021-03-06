export class Trade {
  id: number;
  referenceId: number;
  tradeDate: Date;
  timeOfTrade: Date;
  underlying: string;
  expirationDate: Date;
  strikePrice: number;
  tradeType: string;
  openInterest: number;
  ind: string;
  exchangeCode: string;
  spread: number;
  premiumPrice: number;
  tradeSize: number;
  bidSize: number;
  bidPrice: number;
  askPrice: number;
  askSize: number;
  edge: string;
  leanSize: number;
  sizeRatio: number;
  delta: number;
  theta: number;
  vega: number;
  gamma: number;
  sigma: number;
  rho: number;
}

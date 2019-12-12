package pl.piotrchowaniec.currencycalc.model.dto;

import org.springframework.http.HttpStatus;

public class ExchangeResponse {

    private HttpStatus httpStatus;
    private Exchange exchange;

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public Exchange getExchange() {
        return this.exchange;
    }

    private ExchangeResponse(Builder builder) {
        this.httpStatus = builder.httpStatus;
        this.exchange = builder.exchange;
    }

    public static class Builder {

        private HttpStatus httpStatus;
        private Exchange exchange;

        public Builder(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
        }

        public Builder exchange(Exchange exchange) {
            this.exchange = exchange;
            return this;
        }

        public ExchangeResponse build() {
            return new ExchangeResponse(this);
        }
    }
}


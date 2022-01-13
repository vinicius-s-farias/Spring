create table if not exists stocks(
    id bigint primary key generated always as identity,
    stock_symbol text not null,
    stock_name text not null,
    ask_min numeric,
    ask_max numeric,
    bid_min numeric,
    bid_max numeric,
    created_on timestamp not null default current_timestamp,
    updated_on timestamp not null default current_timestamp
);
CREATE TABLE lots (
                      id            BIGSERIAL PRIMARY KEY,
                      title         VARCHAR(200)  NOT NULL,
                      start_price   NUMERIC(12,2) NOT NULL,
                      min_step      NUMERIC(12,2) NOT NULL,
                      current_price NUMERIC(12,2),
                      leader        VARCHAR(64),
                      status        VARCHAR(16)   NOT NULL DEFAULT 'OPEN',
                      ends_at       TIMESTAMPTZ   NOT NULL,
                      created_at    TIMESTAMPTZ   NOT NULL DEFAULT now(),
                      version       BIGINT        NOT NULL DEFAULT 0
);

COMMENT ON TABLE  lots               IS 'Лоты мини-аукциона';
COMMENT ON COLUMN lots.id            IS 'Уникальный идентификатор лота';
COMMENT ON COLUMN lots.title         IS 'Название лота';
COMMENT ON COLUMN lots.start_price   IS 'Стартовая цена лота';
COMMENT ON COLUMN lots.min_step      IS 'Минимальный шаг повышения ставки';
COMMENT ON COLUMN lots.current_price IS 'Текущая цена лота (NULL, пока нет ставок)';
COMMENT ON COLUMN lots.leader        IS 'Текущий лидер торгов (NULL, пока нет ставок)';
COMMENT ON COLUMN lots.status        IS 'Статус лота: OPEN, CLOSED и т.д.';
COMMENT ON COLUMN lots.ends_at       IS 'Время окончания торгов по лоту';
COMMENT ON COLUMN lots.created_at    IS 'Время создания лота';
COMMENT ON COLUMN lots.version       IS 'Версия записи для оптимистичной блокировки';

CREATE TABLE bids (
                      id         BIGSERIAL PRIMARY KEY,
                      lot_id     BIGINT        NOT NULL REFERENCES lots(id),
                      bidder     VARCHAR(64)   NOT NULL,
                      amount     NUMERIC(12,2) NOT NULL,
                      created_at TIMESTAMPTZ   NOT NULL DEFAULT now()
);

COMMENT ON TABLE  bids            IS 'Ставки участников по лотам';
COMMENT ON COLUMN bids.id         IS 'Уникальный идентификатор ставки';
COMMENT ON COLUMN bids.lot_id     IS 'Идентификатор лота, к которому относится ставка';
COMMENT ON COLUMN bids.bidder     IS 'Участник, сделавший ставку';
COMMENT ON COLUMN bids.amount     IS 'Сумма ставки';
COMMENT ON COLUMN bids.created_at IS 'Время размещения ставки';


CREATE INDEX idx_bids_lot_time ON bids (lot_id, created_at DESC);

CREATE INDEX idx_lots_open_ends ON lots (ends_at) WHERE status = 'OPEN';
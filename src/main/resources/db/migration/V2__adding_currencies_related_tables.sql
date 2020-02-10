CREATE TABLE conversions (
    id INT GENERATED ALWAYS AS IDENTITY,
    currency_from INT NOT NULL,
    currency_to INT NOT NULL,
    amount BIGINT NOT NULL,
    result BIGINT NOT NULL,
    conversion_date DATE NOT NULL,
    user_id INT NOT NULL
);

CREATE TABLE currencies (
    id INT GENERATED ALWAYS AS IDENTITY,
    num_code VARCHAR(10) NOT NULL,
    char_code VARCHAR(10) NOT NULL,
    nominal INT NOT NULL,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE currency_values (
    id BIGINT GENERATED ALWAYS AS IDENTITY,
    rub_value INT NOT NULL,
    value_date DATE NOT NULL,
    currency_id INT NOT NULL
);
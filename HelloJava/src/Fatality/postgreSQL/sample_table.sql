/*tableの指定はスキーマ名.テーブル名の形で指定する*/
create table s_main.t_users(
    u_id SERIAL PRIMARY KEY,/*主キー integerはintの別名*/
    u_name VARCHAR(255) NOT NULL,/*NOT NULLはnullを許可しない name*/
    u_age INT NOT NULL/*NOT NULLはnullを許可しない age*/
);
/*スキーマで分かれていれば同名のテーブルを作成できる*/
create table public.t_users(
    u_id SERIAL PRIMARY KEY,/*主キー integerはintの別名*/
    u_pass VARCHAR(255) NOT NULL,/*NOT NULLはnullを許可しない name*/
    u_email VARCHAR(255) NOT NULL/*NOT NULLはnullを許可しない age*/
);
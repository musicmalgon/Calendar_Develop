CREATE TABLE `todo` (
                        `todo_id`	bigint	NOT NULL auto_increment primary key ,
                        `username`	varchar(255)	NULL,
                        `title`	varchar(255)	NULL,
                        `contents`	varchar(255)	NULL,
                        `created_at`	timestamp	NULL,
                        `updated_at`	timestamp	NULL,
                        `comment_id`	bigint	NOT NULL
);

CREATE TABLE `comment` (
                           `comment_id`	bigint	NOT NULL auto_increment primary key ,
                           `contents`	varchar(255)	NULL,
                           `created_at`	timestamp	NULL,
                           `updated_at`	timestamp	NULL,
                           `username`	varchar(255)	NULL
);
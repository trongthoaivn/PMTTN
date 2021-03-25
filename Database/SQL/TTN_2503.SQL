drop database TTN

create database TTN
go

use TTN

-- Create tables section -------------------------------------------------

-- Table Cauhoi

CREATE TABLE [Cauhoi]
(
 [ma_CH] Int NOT NULL,
 [loai] Bit NULL,
 [nd_CH] Nvarchar(200) NULL,
 [img_CH] Varchar(200) NULL,
 [aud_CH] Varchar(200) NULL,
 [TL_1] Nvarchar(200) NULL,
 [TL_2] Nvarchar(200) NULL,
 [TL_3] Nvarchar(200) NULL,
 [TL_4] Nvarchar(200) NULL,
 [DA] Nvarchar(200) NULL,
 [dokho] Int NULL
)
go

-- Add keys for table Cauhoi

ALTER TABLE [Cauhoi] ADD CONSTRAINT [PK_Cauhoi] PRIMARY KEY ([ma_CH])
go

-- Table Bode

CREATE TABLE [Bode]
(
 [ma_Bode] Char(7) NOT NULL,
 [ten_Bode] Varchar(40) NULL,
 [ma_CH] Int NULL,
 [ma_MH] Varchar(10) NULL,
 [ma_KT] Char(10) NULL
)
go

-- Create indexes for table Bode

CREATE INDEX [IX_Relationship1] ON [Bode] ([ma_CH])
go

CREATE INDEX [IX_Relationship4] ON [Bode] ([ma_MH])
go

CREATE INDEX [IX_Relationship26] ON [Bode] ([ma_KT])
go

-- Add keys for table Bode

ALTER TABLE [Bode] ADD CONSTRAINT [PK_Bode] PRIMARY KEY ([ma_Bode])
go

-- Table Made

CREATE TABLE [Made]
(
 [ma_De] Char(3) NOT NULL,
 [ten_Made] Char(3) NULL,
 [ma_CHde] Varchar(300) NULL,
 [ma_Bode] Char(7) NULL
)
go

-- Create indexes for table Made

CREATE INDEX [IX_Relationship3] ON [Made] ([ma_Bode])
go

-- Add keys for table Made

ALTER TABLE [Made] ADD CONSTRAINT [PK_Made] PRIMARY KEY ([ma_De])
go

-- Table Monhoc

CREATE TABLE [Monhoc]
(
 [ma_MH] Varchar(10) NOT NULL,
 [ten_MH] Nvarchar(40) NULL
)
go

-- Add keys for table Monhoc

ALTER TABLE [Monhoc] ADD CONSTRAINT [PK_Monhoc] PRIMARY KEY ([ma_MH])
go

-- Table Kythi

CREATE TABLE [Kythi]
(
 [ma_KT] Char(10) NOT NULL,
 [ten_KT] Nvarchar(50) NULL,
 [ngaythi] Datetime NULL,
 [tg_Lambai] Int NULL,
 [tg_Batdau] Time NULL,
 [tg_Ketthuc] Time NULL,
 [sl_CH] Int NULL,
 [ma_MH] Varchar(10) NULL,
 [ma_GV] Char(10) NULL,
 [ma_HS] Char(10) NULL
)
go

-- Create indexes for table Kythi

CREATE INDEX [IX_Relationship5] ON [Kythi] ([ma_MH])
go

CREATE INDEX [IX_Relationship6] ON [Kythi] ([ma_GV])
go

CREATE INDEX [IX_Relationship8] ON [Kythi] ([ma_HS])
go

-- Add keys for table Kythi

ALTER TABLE [Kythi] ADD CONSTRAINT [PK_Kythi] PRIMARY KEY ([ma_KT])
go

-- Table Ketqua

CREATE TABLE [Ketqua]
(
 [ma_KQ] Char(10) NOT NULL,
 [ngaythi] Datetime NULL,
 [diem] Float NULL,
 [xeploai] Bit NULL,
 [ma_KT] Char(10) NULL,
 [ma_HS] Char(10) NULL
)
go

-- Create indexes for table Ketqua

CREATE INDEX [IX_Relationship7] ON [Ketqua] ([ma_KT])
go

CREATE INDEX [IX_Relationship27] ON [Ketqua] ([ma_HS])
go

-- Add keys for table Ketqua

ALTER TABLE [Ketqua] ADD CONSTRAINT [PK_Ketqua] PRIMARY KEY ([ma_KQ])
go

-- Table Baithi

CREATE TABLE [Baithi]
(
 [ma_Baithi] Char(10) NOT NULL,
 [ma_CH] Int NULL,
 [DA] Nvarchar(200) NULL,
 [ma_KQ] Char(10) NOT NULL
)
go

-- Add keys for table Baithi

ALTER TABLE [Baithi] ADD CONSTRAINT [PK_Baithi] PRIMARY KEY ([ma_Baithi],[ma_KQ])
go

-- Table Khoi

CREATE TABLE [Khoi]
(
 [ma_Khoi] Varchar(10) NOT NULL,
 [ten_Khoi] Varchar(5) NULL
)
go

-- Add keys for table Khoi

ALTER TABLE [Khoi] ADD CONSTRAINT [PK_Khoi] PRIMARY KEY ([ma_Khoi])
go

-- Table Lop

CREATE TABLE [Lop]
(
 [ma_Lop] Varchar(10) NOT NULL,
 [ten_Lop] Varchar(5) NULL,
 [ma_Khoi] Varchar(10) NULL
)
go

-- Create indexes for table Lop

CREATE INDEX [IX_Relationship9] ON [Lop] ([ma_Khoi])
go

-- Add keys for table Lop

ALTER TABLE [Lop] ADD CONSTRAINT [PK_Lop] PRIMARY KEY ([ma_Lop])
go

-- Table Hocsinh

CREATE TABLE [Hocsinh]
(
 [ma_HS] Char(10) NOT NULL,
 [ten_HS] Nvarchar(50) NULL,
 [ngaysinh] Date NULL,
 [img_HS] Image NULL,
 [ma_Lop] Varchar(10) NULL,
 [username] Char(10) NOT NULL
)
go

-- Create indexes for table Hocsinh

CREATE INDEX [IX_Relationship10] ON [Hocsinh] ([ma_Lop])
go

CREATE INDEX [IX_Relationship7] ON [Hocsinh] ([username])
go

-- Add keys for table Hocsinh

ALTER TABLE [Hocsinh] ADD CONSTRAINT [PK_Hocsinh] PRIMARY KEY ([ma_HS])
go

-- Table Taikhoan

CREATE TABLE [Taikhoan]
(
 [username] Char(10) NOT NULL,
 [passwords] Char(20) NULL,
 [trangthai] Bit NULL,
 [ma_Quyen] Bit NOT NULL
)
go

-- Create indexes for table Taikhoan

CREATE INDEX [IX_Relationship6] ON [Taikhoan] ([ma_Quyen])
go

-- Add keys for table Taikhoan

ALTER TABLE [Taikhoan] ADD CONSTRAINT [PK_Taikhoan] PRIMARY KEY ([username])
go

-- Table Quyen

CREATE TABLE [Quyen]
(
 [ma_Quyen] Bit NOT NULL,
 [ten_Quyen] Char(10) NULL
)
go

-- Add keys for table Quyen

ALTER TABLE [Quyen] ADD CONSTRAINT [PK_Quyen] PRIMARY KEY ([ma_Quyen])
go

-- Table Giaovien

CREATE TABLE [Giaovien]
(
 [ma_GV] Char(10) NOT NULL,
 [ten_GV] Nvarchar(50) NULL,
 [ngaysinh] Date NULL,
 [img_GV] Varchar(200) NULL,
 [username] Char(10) NOT NULL
)
go

-- Create indexes for table Giaovien

CREATE INDEX [IX_Relationship8] ON [Giaovien] ([username])
go

-- Add keys for table Giaovien

ALTER TABLE [Giaovien] ADD CONSTRAINT [PK_Giaovien] PRIMARY KEY ([ma_GV])
go

-- Table Admin

CREATE TABLE [Admin]
(
 [ma_Ad] Char(10) NOT NULL,
 [ten_Ad] Nvarchar(50) NULL,
 [ngaysinh] Datetime NULL,
 [img_Ad] Varchar(200) NULL,
 [username] Char(10) NOT NULL
)
go

-- Create indexes for table Admin

CREATE INDEX [IX_Relationship9] ON [Admin] ([username])
go

-- Add keys for table Admin

ALTER TABLE [Admin] ADD CONSTRAINT [PK_Admin] PRIMARY KEY ([ma_Ad])
go

-- Create foreign keys (relationships) section ------------------------------------------------- 


ALTER TABLE [Bode] ADD CONSTRAINT [Bode_CH] FOREIGN KEY ([ma_CH]) REFERENCES [Cauhoi] ([ma_CH]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Made] ADD CONSTRAINT [MH_Made] FOREIGN KEY ([ma_Bode]) REFERENCES [Bode] ([ma_Bode]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Bode] ADD CONSTRAINT [NH_Bode] FOREIGN KEY ([ma_MH]) REFERENCES [Monhoc] ([ma_MH]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Kythi] ADD CONSTRAINT [MH_KT] FOREIGN KEY ([ma_MH]) REFERENCES [Monhoc] ([ma_MH]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Kythi] ADD CONSTRAINT [GV_KT] FOREIGN KEY ([ma_GV]) REFERENCES [Giaovien] ([ma_GV]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Ketqua] ADD CONSTRAINT [KQ_KT] FOREIGN KEY ([ma_KT]) REFERENCES [Kythi] ([ma_KT]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Kythi] ADD CONSTRAINT [KT_HS] FOREIGN KEY ([ma_HS]) REFERENCES [Hocsinh] ([ma_HS]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Lop] ADD CONSTRAINT [Khoi_Lop] FOREIGN KEY ([ma_Khoi]) REFERENCES [Khoi] ([ma_Khoi]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Hocsinh] ADD CONSTRAINT [HS_Lop] FOREIGN KEY ([ma_Lop]) REFERENCES [Lop] ([ma_Lop]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Baithi] ADD CONSTRAINT [KQ_TL] FOREIGN KEY ([ma_KQ]) REFERENCES [Ketqua] ([ma_KQ]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Bode] ADD CONSTRAINT [Bode_KT] FOREIGN KEY ([ma_KT]) REFERENCES [Kythi] ([ma_KT]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Ketqua] ADD CONSTRAINT [KQ_HS] FOREIGN KEY ([ma_HS]) REFERENCES [Hocsinh] ([ma_HS]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Taikhoan] ADD CONSTRAINT [TK_ Quyen] FOREIGN KEY ([ma_Quyen]) REFERENCES [Quyen] ([ma_Quyen]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Hocsinh] ADD CONSTRAINT [HS_TK] FOREIGN KEY ([username]) REFERENCES [Taikhoan] ([username]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Giaovien] ADD CONSTRAINT [GV_TK] FOREIGN KEY ([username]) REFERENCES [Taikhoan] ([username]) ON UPDATE NO ACTION ON DELETE NO ACTION
go



ALTER TABLE [Admin] ADD CONSTRAINT [Ad_TK] FOREIGN KEY ([username]) REFERENCES [Taikhoan] ([username]) ON UPDATE NO ACTION ON DELETE NO ACTION
go





USE [master]
GO
/****** Object:  Database [TTN]    Script Date: 5/22/2021 8:33:04 AM ******/
CREATE DATABASE [TTN]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TTN', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.SQLEXPRESS\MSSQL\DATA\TTN.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'TTN_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.SQLEXPRESS\MSSQL\DATA\TTN_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [TTN] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TTN].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TTN] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TTN] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TTN] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TTN] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TTN] SET ARITHABORT OFF 
GO
ALTER DATABASE [TTN] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [TTN] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TTN] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TTN] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TTN] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TTN] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TTN] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TTN] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TTN] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TTN] SET  DISABLE_BROKER 
GO
ALTER DATABASE [TTN] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TTN] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TTN] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TTN] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TTN] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TTN] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TTN] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TTN] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [TTN] SET  MULTI_USER 
GO
ALTER DATABASE [TTN] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TTN] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TTN] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TTN] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [TTN] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [TTN] SET QUERY_STORE = OFF
GO
USE [TTN]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [TTN]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 5/22/2021 8:33:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[ma_Ad] [varchar](14) NOT NULL,
	[ten_Ad] [nvarchar](50) NULL,
	[ngaysinh] [datetime] NULL,
	[img_Ad] [varchar](200) NULL,
	[username] [varchar](14) NOT NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[ma_Ad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Baithi]    Script Date: 5/22/2021 8:33:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Baithi](
	[ma_Baithi] [char](10) NOT NULL,
	[ma_CH] [int] NULL,
	[DA] [nvarchar](200) NULL,
	[ma_KQ] [char](10) NOT NULL,
 CONSTRAINT [PK_Baithi] PRIMARY KEY CLUSTERED 
(
	[ma_Baithi] ASC,
	[ma_KQ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bode]    Script Date: 5/22/2021 8:33:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bode](
	[ma_Bode] [char](7) NOT NULL,
	[ten_Bode] [nvarchar](40) NULL,
	[ma_MH] [varchar](10) NULL,
	[ma_KT] [char](10) NULL,
 CONSTRAINT [PK_Bode] PRIMARY KEY CLUSTERED 
(
	[ma_Bode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cauhoi]    Script Date: 5/22/2021 8:33:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cauhoi](
	[ma_CH] [int] NOT NULL,
	[ma_Bode] [char](7) NULL,
	[loai] [bit] NULL,
	[nd_CH] [nvarchar](200) NULL,
	[img_CH] [varchar](200) NULL,
	[aud_CH] [varchar](200) NULL,
	[TL_1] [nvarchar](200) NULL,
	[TL_2] [nvarchar](200) NULL,
	[TL_3] [nvarchar](200) NULL,
	[TL_4] [nvarchar](200) NULL,
	[DA] [nvarchar](200) NULL,
	[dokho] [int] NULL,
 CONSTRAINT [PK_Cauhoi] PRIMARY KEY CLUSTERED 
(
	[ma_CH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Gacthi]    Script Date: 5/22/2021 8:33:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Gacthi](
	[ma_KT] [char](10) NOT NULL,
	[ma_GV] [varchar](14) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_GV] ASC,
	[ma_KT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Giaovien]    Script Date: 5/22/2021 8:33:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Giaovien](
	[ma_GV] [varchar](14) NOT NULL,
	[ten_GV] [nvarchar](50) NULL,
	[ngaysinh] [datetime] NULL,
	[img_GV] [varchar](200) NULL,
	[username] [varchar](14) NOT NULL,
 CONSTRAINT [PK_Giaovien] PRIMARY KEY CLUSTERED 
(
	[ma_GV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hocsinh]    Script Date: 5/22/2021 8:33:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hocsinh](
	[ma_HS] [varchar](14) NOT NULL,
	[ten_HS] [nvarchar](50) NULL,
	[ngaysinh] [datetime] NULL,
	[img_HS] [varchar](200) NULL,
	[ma_Lop] [varchar](4) NULL,
	[username] [varchar](14) NOT NULL,
 CONSTRAINT [PK_Hocsinh] PRIMARY KEY CLUSTERED 
(
	[ma_HS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ketqua]    Script Date: 5/22/2021 8:33:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ketqua](
	[ma_KQ] [char](10) NOT NULL,
	[ngaythi] [datetime] NULL,
	[diem] [float] NULL,
	[xeploai] [bit] NULL,
	[ma_KT] [char](10) NULL,
	[ma_HS] [varchar](14) NULL,
 CONSTRAINT [PK_Ketqua] PRIMARY KEY CLUSTERED 
(
	[ma_KQ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Khoi]    Script Date: 5/22/2021 8:33:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Khoi](
	[ma_Khoi] [varchar](2) NOT NULL,
	[ten_Khoi] [nvarchar](50) NULL,
 CONSTRAINT [PK_Khoi] PRIMARY KEY CLUSTERED 
(
	[ma_Khoi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Kythi]    Script Date: 5/22/2021 8:33:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Kythi](
	[ma_KT] [char](10) NOT NULL,
	[ten_KT] [nvarchar](50) NULL,
	[ngaythi] [datetime] NULL,
	[tg_Lambai] [int] NULL,
	[tg_Batdau] [time](7) NULL,
	[tg_Ketthuc] [time](7) NULL,
	[sl_CH] [int] NULL,
	[ma_MH] [varchar](10) NULL,
 CONSTRAINT [PK_Kythi] PRIMARY KEY CLUSTERED 
(
	[ma_KT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Lop]    Script Date: 5/22/2021 8:33:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Lop](
	[ma_Lop] [varchar](4) NOT NULL,
	[ten_Lop] [nvarchar](5) NULL,
	[ma_Khoi] [varchar](2) NULL,
 CONSTRAINT [PK_Lop] PRIMARY KEY CLUSTERED 
(
	[ma_Lop] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Made]    Script Date: 5/22/2021 8:33:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Made](
	[ma_De] [char](10) NOT NULL,
	[ten_Made] [char](3) NULL,
	[ma_CHde] [varchar](300) NULL,
	[ma_Bode] [char](7) NULL,
 CONSTRAINT [PK_Made] PRIMARY KEY CLUSTERED 
(
	[ma_De] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Monhoc]    Script Date: 5/22/2021 8:33:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Monhoc](
	[ma_MH] [varchar](10) NOT NULL,
	[ten_MH] [nvarchar](40) NULL,
 CONSTRAINT [PK_Monhoc] PRIMARY KEY CLUSTERED 
(
	[ma_MH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Quyen]    Script Date: 5/22/2021 8:33:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quyen](
	[ma_Quyen] [int] NOT NULL,
	[ten_Quyen] [char](10) NULL,
 CONSTRAINT [PK_Quyen] PRIMARY KEY CLUSTERED 
(
	[ma_Quyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Taikhoan]    Script Date: 5/22/2021 8:33:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Taikhoan](
	[username] [varchar](14) NOT NULL,
	[passwords] [varchar](50) NULL,
	[trangthai] [bit] NULL,
	[ma_Quyen] [int] NOT NULL,
 CONSTRAINT [PK_Taikhoan] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Thisinh]    Script Date: 5/22/2021 8:33:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Thisinh](
	[ma_KT] [char](10) NOT NULL,
	[ma_HS] [varchar](14) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_HS] ASC,
	[ma_KT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Admin] ([ma_Ad], [ten_Ad], [ngaysinh], [img_Ad], [username]) VALUES (N'AD1', N'Nguyễn Huỳnh Trọng Thoại', CAST(N'2000-02-22T00:00:00.000' AS DateTime), N'DataSet/CV1.jpg', N'admin1    ')
INSERT [dbo].[Admin] ([ma_Ad], [ten_Ad], [ngaysinh], [img_Ad], [username]) VALUES (N'AD2', N'Nguyễn Thanh Trọng', CAST(N'2000-01-01T00:00:00.000' AS DateTime), N'DataSet/trong.jpg', N'admin2')
INSERT [dbo].[Admin] ([ma_Ad], [ten_Ad], [ngaysinh], [img_Ad], [username]) VALUES (N'AD4', N'Huỳnh Quốc Huy', CAST(N'2020-02-01T00:00:00.000' AS DateTime), N'DataSet/mau.jpg', N'admin4')
GO
INSERT [dbo].[Bode] ([ma_Bode], [ten_Bode], [ma_MH], [ma_KT]) VALUES (N'BIO2020', N'Kiểm tra 1 tiết sinh học 10 (Cô Ngọc)', N'BIO', NULL)
INSERT [dbo].[Bode] ([ma_Bode], [ten_Bode], [ma_MH], [ma_KT]) VALUES (N'ENG2020', N'Thi học kì 1 Tiếng Anh ( Tổ Anh văn)', N'ENG', NULL)
GO
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (1, N'ENG2020', 1, N'They do not have ______ pets as they are too busy to take care of animals.', N'', N'', N' some', N' any', N' a', N' every', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (2, N'ENG2020', 1, N'_____ plants recycle carbon dioxide and create oxygen, which we need to breathe. _____ most of our food comes from _____ plants.', N'', N'', N' W / W / W', N' The / W / the', N' W / the / W', N' W / a / the', N'A', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (3, N'ENG2020', 1, N'The plane crash wouldn’t have happened if the fog at the airport ______ so thick at the time.', N'', N'', N' hadn’t been', N' won’t be', N' wasn’t', N' hasn’t been', N'A', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (4, N'ENG2020', 1, N'You look really great! ______ at the fitness center?', N'', N'', N' do you exercise', N' did you exercise', N' Have you exercised', N' will you exercised', N'C', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (5, N'ENG2020', 1, N'It’s ages since they last ______ abroad.', N'', N'', N' travel', N' travelled', N' have travelled', N' was travelling', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (6, N'ENG2020', 1, N'Jim, _____ old friend of mine, used to work in _____ downtown Los Angeles. He had a good Job in one of _____ biggest law firms in the city.', N'', N'', N' an / the / W', N' a / the / W', N' the / W / a', N' an / W / the', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (7, N'ENG2020', 1, N'When I arrived home, my father wasn’t there. He ______ out.', N'', N'', N' has gone', N' went', N' goes', N' had gone', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (8, N'ENG2020', 1, N'She is always ______ her pencil on the desk and it’s getting on my nerves!', N'', N'', N' droped', N' droping', N' tapped', N' tapping', N'D', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (9, N'ENG2020', 1, N'We weren’t hungry. We ______ just ______ lunch.', N'', N'', N' have / had', N' have / eaten', N' had / had', N' had / been having', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (10, N'ENG2020', 1, N'They ______ running for three hours when the storm suddenly broke.', N'', N'', N' have been', N' had been', N' are', N' went', N'B', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (11, N'ENG2020', 1, N'I ______ at the doors five times. I don''t think anyone''s in.', N'', N'', N' have knocked', N' knock', N' knocked', N' was knocking', N'A', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (12, N'ENG2020', 1, N'_____ more you read _____ smarter you are.', N'', N'', N' W / the', N' The / the', N' W / W', N' The / W', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (13, N'ENG2020', 1, N'If I ______ hungry, I ______ something.', N'', N'', N' had been, would eat', N' had been, would have eaten', N' were, would eat', N' were, would have eaten', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (14, N'ENG2020', 1, N'I’m tired. I need ______ rest.', N'', N'', N' a few', N' a large number of', N' many', N' plenty of', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (15, N'ENG2020', 1, N'David’s parents buy him ______ toys. They are trying to make up for always being at work.', N'', N'', N' a certain amount of', N' a great deal of', N' a lot of', N' a large amount of', N'C', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (16, N'ENG2020', 1, N'If orange blossoms ______ to very cold temperatures, they ______.', N'', N'', N' is exposed / wither and died', N' exposes / withered and died', N' expose / wither and died', N' are exposed / will wither and die', N'C', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (17, N'ENG2020', 1, N'A: Does she love him? B: Of course. If she ______ him, she ______ him today', N'', N'', N' loves / marries', N' loved / married', N' doesn’t love / doesn’t marry', N' didn’t love / didn’t marry', N'C', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (18, N'ENG2020', 1, N'______ research has been done into the cause of cancer.', N'', N'', N' A couple of', N' A small number of', N' Plenty of', N' A great number of', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (19, N'ENG2020', 1, N'My friend eventually decided to get divorced, _____ upset me a lot.', N'', N'', N' who', N' why', N' that', N' which', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (20, N'ENG2020', 1, N'The woman _____ hair is long and curly is the new secretary, Mrs.Chan.', N'', N'', N' who', N' whose', N' that', N' which', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (21, N'ENG2020', 1, N'We’ll phone as soon as we ______ the information.', N'', N'', N' will have', N' have', N' are having', N' are going to have', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (22, N'ENG2020', 1, N'At this time last week I ______ on the beach with my friends in Florida.', N'', N'', N' lied', N' was lieing', N' was laying', N' was lying', N'C', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (23, N'ENG2020', 1, N'Would you like something to drink? There''s ______ very good beer in the fridge.', N'', N'', N' a', N' many', N' little', N' some', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (24, N'ENG2020', 1, N'I really hope I ______ you again.', N'', N'', N' shall see', N' won’t see', N' am going to see', N' have seen', N'A', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (25, N'ENG2020', 1, N'It cost me ______ money to rebuil the house.', N'', N'', N' many', N' a great amount of', N' a few', N' a great deal of', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (26, N'ENG2020', 1, N'_____ is a quality all human beings have.', N'', N'', N' Creativity may take many forms', N' Creativity, may take many forms,', N' Creativity which may take many forms,', N' Creativity, which may take many forms,', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (27, N'ENG2020', 1, N'The number of books that I prossess is ______ that of my friend.', N'', N'', N' many', N' greater', N' lots of', N' lesser', N'B', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (28, N'ENG2020', 1, N'We ______ students, so we ______ to school on weekdays.', N'', N'', N' are / go often', N' are / often go', N' are / have often gone', N' have been / are often going', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (29, N'ENG2020', 1, N'Since we moved house. I’ve had to get up ______ for school than before.', N'', N'', N' early', N' earliest', N' more early', N' earlier', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (30, N'ENG2020', 1, N'If you ______ your bed in the morning, your room ______ better when you got back in the afternoon.', N'', N'', N' make / will look', N' made / will look', N' made / looks', N' made / would look', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (31, N'ENG2020', 1, N'If I still ______ sick, I ______ on vacation next weekend.', N'', N'', N' feel / don’t go', N' fell / gol', N' fell / won’t go', N' fell / will go', N'C', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (32, N'ENG2020', 1, N'This new camera is really cheap! It is ______than my old one.', N'', N'', N' expensive', N' less expensive', N' much expensive', N' more expensive', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (33, N'ENG2020', 1, N'The play only ______ a couple of minutes ago so we haven’t missed much.', N'', N'', N' start', N' started', N' has started', N' was starting', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (34, N'ENG2020', 1, N'“Did you go to Hawaii for vacation?” “I ______ to go, but I got sick at the last minute”.', N'', N'', N' was planned', N' had planning', N' had been planning', N' have planned', N'C', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (35, N'ENG2020', 1, N'The customer ______ by the salesman just as the thief came into the store.', N'', N'', N' was being helped', N' helped', N' was helping', N' helps', N'A', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (36, N'ENG2020', 1, N'He grew up in _____ orphanage in _____ United Kingdom.', N'', N'', N' the / W', N' an / an', N' the / an', N' an / the', N'D', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (37, N'ENG2020', 1, N'We shouldn’t eat ______ chocolate.', N'', N'', N' a lot of', N' a great number of', N' a large number of', N' a large quantity of', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (38, N'ENG2020', 1, N'She never ______ when someone leaves her a message.', N'', N'', N' call back', N' will call back', N' has called back', N' calls back', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (39, N'ENG2020', 1, N'Every time we ______ to that restaurant, my stomach gets upset.', N'', N'', N' will go', N' went', N' go', N' have gone', N'C', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (40, N'ENG2020', 1, N'The economic situation ______ getting any better and I think next year will be just as bad.', N'', N'', N' isn’t', N' is', N' be', N' has being', N'A', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (41, N'ENG2020', 1, N'I was surprised how easy it was to use the computer. I thought it would be______.', N'', N'', N' easier', N' more easy', N' more difficult', N' much difficult', N'C', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (42, N'ENG2020', 1, N'If it ______ for the life jacket, I would have drowned.', N'', N'', N' is not', N' was not', N' has not been', N' had not been', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (43, N'ENG2020', 1, N'“I took the TOEFL. It was really hard “. “______ a lot of before you took it?”', N'', N'', N' Have you studied', N' did you studied', N' do you study', N' had you studied', N'A', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (44, N'ENG2020', 1, N'If I hadn’t been so nervous, I ______ the exam.', N'', N'', N' would pass', N' will have passed', N' would have passed', N' had passed', N'C', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (45, N'ENG2020', 1, N'He was sitting on the beach when he ______ a noise.', N'', N'', N' heard', N' was hearing', N' hears', N' hear', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (46, N'ENG2020', 1, N'She decided not to go, for ______ reasons.', N'', N'', N' a number of', N' much', N' a large amount of', N' little', N'A', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (47, N'ENG2020', 1, N'At midnight yesterday, we ______ still ______ through the desert.', N'', N'', N' are / driven', N' were / driven', N' were / driving', N' are / driving', N'C', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (48, N'ENG2020', 1, N'If a live sponge ______ into pieces, each piece ______ into a new sponge like the original one.', N'', N'', N' break / turn', N' broke / would turned', N' is broken / will turn', N' will break / turn', N'C', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (49, N'ENG2020', 1, N'Do you have ______ idea who could have borrowed your bicycle?', N'', N'', N' some', N' an', N' neither', N' any', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (50, N'ENG2020', 1, N'If the cerebellum of a pigeon ______ the bird ______ to fly.', N'', N'', N' was destroyed / aren’t able to fly', N' were destroyed / would not be able', N' destroyed / wasn’t able', N' destroyed / would not be able', N'B', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (51, N'ENG2020', 1, N'We’ll go out for dinner when he ______ in.', N'', N'', N' got', N' gets', N' will get', N' has got', N'B', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (52, N'ENG2020', 1, N'It ______ midnight by the time we get home.', N'', N'', N' is', N' has', N' has been', N' will be', N'D', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (53, N'ENG2020', 1, N'I ______ to South America several times.', N'', N'', N' travel', N' travelled', N' have travelled', N' had travelled', N'C', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (54, N'ENG2020', 1, N'She likes reading _____ books, collecting _____ stamps and going to _____ cinema.', N'', N'', N' the/ W/ W', N' W/ W/ the', N' W/ the/ W', N' W/ the/ a', N'B', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (55, N'ENG2020', 1, N'My country borders on _____ Pacific Ocean.', N'', N'', N' a', N' an', N' the', N' W', N'C', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (56, N'ENG2020', 1, N'_____ last night the hurricane was heading into _____ Gulf of Mexico.', N'', N'', N' The / W', N' W / the', N' The / a', N' A / W', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (57, N'ENG2020', 1, N'While Adam ______ his flock of sheep, he spent much of his time reading.', N'', N'', N' watched', N' was watching', N' was looking', N' was seeing', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (58, N'ENG2020', 1, N'If teaching ______ less, teachers ______ the profession.', N'', N'', N' paid / would leave', N' pays / left', N' had paid / would leave', N' is paying / leave', N'A', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (59, N'ENG2020', 1, N'My aunt has got ______ money. She is a millionaire.', N'', N'', N' many of', N' a large number of', N' lots of', N' several of', N'C', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (60, N'ENG2020', 1, N'I assumed you ______ paying for the repairs until last year.', N'', N'', N' had', N' have been', N' had been', N' have never been', N'C', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (61, N'ENG2020', 1, N'We’ve run out of gas. If you ______ to me sometimes instead of being so stubborn, you ______ me saying that we were running low. Then we ______ stuck here.', N'', N'', N' listened / would hear / wouldn’t be', N' would listen / heard / wouldn’t be', N' listened / heard / wouldn’t be', N' listened / wouldn’t hear / would be', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (62, N'ENG2020', 1, N'My wife is ______ beautiful than that film star.', N'', N'', N' more much', N' various more', N' a lot more', N' many more', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (63, N'ENG2020', 1, N'If you ______ to much water in rice when you cook it, it ______ sticky.', N'', N'', N' put / would get', N' will put / get', N' put / got', N' put / will get', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (64, N'ENG2020', 1, N'I was born in _____ warm family. My parents are both _____ teachers of English. So, I am good at _____ English.', N'', N'', N' a / W / W', N' the / the / an', N' a / the / the', N' the / W / an', N'A', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (65, N'ENG2020', 1, N'I hear you weren''t feeling very well yesterday. Do you feel ______ better today?', N'', N'', N' any', N' more', N' a', N' many', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (66, N'ENG2020', 1, N'“Have some more to eat.” “No, thanks. I have had ______.”', N'', N'', N' few', N' little', N' plenty', N' some', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (67, N'ENG2020', 1, N'Lee, my classmate, comes from _____ Philippines. He not only plays ______ football very well but also is good at _____ mathematics.', N'', N'', N' W / W / the', N' the / a / the', N' W / the / the', N' the / W / W', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (68, N'ENG2020', 1, N'_____ used to be the tallest building in the world, is still a popular tourist attraction.', N'', N'', N' The Empire State Building', N' It is The Empire State Building, which', N' The Empire State Building, that', N' The Empire State Building, which', N'D', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (69, N'ENG2020', 1, N'I ______ not ______ you any more of my things. I never get them back.', N'', N'', N' am / lending', N' do / lend', N' am / borrowing', N' do / borrow', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (70, N'ENG2020', 1, N'The market ______. We are selling more and more of our top of the range products than before.', N'', N'', N' increases', N' improves', N' is increased', N' is improving', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (71, N'ENG2020', 1, N'You make such delicious chocolate cake! If you ______ them, you ______ a fortune.', N'', N'', N' sell / will make', N' sell / make', N' will sell / make', N' will sell / will make', N'A', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (72, N'ENG2020', 1, N'As soon as we ______ the news, we rushed to the hospital.', N'', N'', N' hear', N' had heard', N' were hearing', N' have heard', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (73, N'ENG2020', 1, N'No one ______ your story when you tell them.', N'', N'', N' is going to believe', N' will believe', N' believe', N' has believe', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (74, N'ENG2020', 1, N'Can I have ______ milk in my coffee, please?', N'', N'', N' Some', N' any', N' little', N' many', N'C', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (75, N'ENG2020', 1, N'If I ______ them, they might take off and I ______ never see them again.', N'', N'', N' frighten / will', N' frighten / would', N' frightened / would', N' frightened / will', N'C', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (76, N'ENG2020', 1, N'______ the teacher ______ how to use the present continuous tense to the class now?', N'', N'', N' Is / explaining', N' Do / explain', N' Does / explain', N' Have / explaining', N'A', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (77, N'ENG2020', 1, N'I''m sure they ______ married and live happily ever afterwards.', N'', N'', N' will get', N' have got', N' are going', N' got', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (78, N'ENG2020', 1, N'______ to Australia? – Yes, I went there when I was a little boy.', N'', N'', N' did you ever go', N' do you ever go', N' have you ever been', N' have you ever gone', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (79, N'ENG2020', 1, N'Helen ______ so hard today that she ______ no time to play her weekly game of tennis.', N'', N'', N' worked / had had', N' worked / has had', N' has worked / has had', N' has worked / had', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (80, N'ENG2020', 1, N'I can assure you that this box ______ before I opened it this morning.', N'', N'', N' has never been opened', N' wasn’t opened', N' had never been opened', N' had never opened', N'C', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (81, N'ENG2020', 1, N'He made the wrong decision and so the situation is now even ______.', N'', N'', N' better', N' good', N' worse', N' bad', N'C', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (82, N'ENG2020', 1, N'Tom said he was _____ employee at _____ fast food restaurant. _____ restaurant is on Boston Street.', N'', N'', N' An / the / A', N' W / the / A', N' The / W / The', N' An / a / The', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (83, N'ENG2020', 1, N'I saw a lot of new people at the party, _____ seemed familiar.', N'', N'', N' which', N' that', N' some of that', N' some of whom', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (84, N'ENG2020', 1, N'The experience left him sadder but ______.', N'', N'', N' wiser', N' worse', N' waster', N' wonder', N'A', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (85, N'ENG2020', 1, N'There is no question that they ______ delighted when they see her tomorrow.', N'', N'', N' are', N' aren’t', N' won’t be', N' will be', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (86, N'ENG2020', 1, N'The thieves stole ______ books from the library.', N'', N'', N' a large number of', N' a great deal of', N' much', N' a large amount of', N'A', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (87, N'ENG2020', 1, N'Look! That man’s running out of the bank! And he’s ______ a large bag full of money!', N'', N'', N' carrier', N' carrying', N' carried', N' carries', N'B', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (88, N'ENG2020', 1, N'He’s made a ot of friends since he ______ here.', N'', N'', N' comes', N' come', N' came', N' has come', N'C', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (89, N'ENG2020', 1, N'We have invited ______ students to the party.', N'', N'', N' some', N' any', N' much', N' little', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (90, N'ENG2020', 1, N'If you ______ two apples, you ______ one free.', N'', N'', N' buy / get', N' bought / get', N' buy / got', N' buy / will get', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (91, N'ENG2020', 1, N'If light ______ a rough surface, it ______.', N'', N'', N' strike / diffused', N' strikes / will diffuse', N' struck / would diffuse', N' would strike / diffused', N'B', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (92, N'ENG2020', 1, N'If the trajectory of a satellite ______ slightly off at launch, it ______ worse as the flight progresses.', N'', N'', N' is / will get', N' are / get', N' was / got', N' were / would get', N'A', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (93, N'ENG2020', 1, N'What ______ you ______ to John about when I saw you in the cafeteria yesterday?', N'', N'', N' are / talking', N' were / talking', N' did / talk', N' do / talk', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (94, N'ENG2020', 1, N'I ______ there once a long time ago and have not been back since.', N'', N'', N' went', N' have gone', N' was going', N' had gone', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (95, N'ENG2020', 1, N'Do you know any planes which travel ______than the speed of sound?', N'', N'', N' fastest', N' fastlier', N' fastly', N' faster', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (96, N'ENG2020', 1, N'We went to lunch to early. When we arrived the food ______ still ______ .', N'', N'', N' was / cook', N' was / cooked', N' was / being cooking', N' has being cooked', N'C', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (97, N'ENG2020', 1, N'We ______ more chances to attack during the last game if the strikers ______ the ball more exactly.', N'', N'', N' will have had / have passed', N' will have / were passing', N' would have / passed', N' would have had / had passed', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (98, N'ENG2020', 1, N'I hope to find a ______ comfortable sofa than the one I have now', N'', N'', N' more', N' less', N' many', N' much', N'A', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (99, N'ENG2020', 1, N'Karen didn’t want to go to the cinema with us beacause she ______ already ______ the movie.', N'', N'', N' had / seen', N' has / seen', N' has / gone', N' was / seeing', N'A', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (100, N'ENG2020', 1, N'“I don''t like you criticizing them like that”. “Sorry, I ______ it again.”', N'', N'', N' don’t do', N' haven’t done', N' won’t do', N' am not doing', N'A', 4)
GO
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (101, N'BIO2020', 1, N'Hãy chọn cụm từ thích hợp điền vào chỗ trống trong khái niệm “Môi trường bao gồm………………..bao quanh con người, có ảnh hưởng đến đời sống, sản xuất, sự tồn tại, phát triển của con người và sinh vật”', N'', N'', N' “các hoàn cảnh vật lý, hóa học và sinh học”', N' “các yếu tố vật lý, hóa học, sinh học và kinh tế - xã hội”', N' “các yếu tố tự nhiên và vật chất nhân tạo”', N' Ba câu A, B và C đều đúng', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (102, N'BIO2020', 1, N'Khoáng sản kim loại thuộc loại tài nguyên nào:', N'', N'', N' Tài nguyên vĩnh viễn', N' Tài nguyên có thể phục hồi', N' Tài nguyên không thể phục hồi', N' Tài nguyên vô hạn', N'C', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (103, N'BIO2020', 1, N'Trái đất có 4 quyển chính, bao gồm: (1) Địa quyển, (2) Thủy quyển, (3) Khí quyển và (4)……', N'', N'', N' Thạch quyển', N' Địa quyển', N' Sinh quyển', N' Trung quyển', N'C', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (104, N'BIO2020', 1, N'Dạng tài nguyên nào sau đây không phải là tài nguyên có thể phục hồi:', N'', N'', N' Tài nguyên đất phì nhiêu', N' Tài nguyên nhiên liệu hóa thạch', N' Tài nguyên sinh vật', N' Ba câu A, B và C đều đúng', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (105, N'BIO2020', 1, N'Nước ngọt thuộc dạng tài nguyên nào:', N'', N'', N' Tài nguyên vĩnh viễn', N' Tài nguyên có thể phục hồi', N' Tài nguyên không thể phục hồi', N' Tài nguyên vô hạn', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (106, N'BIO2020', 1, N'Chọn phát biểu phù hợp theo nhận thức mới về môi trường', N'', N'', N' Trái Đất có nguồn tài nguyên hữu hạn', N' Lúc tài nguyên hết hãy tìm nơi khác', N' Con người phải chinh phục thiên nhiên', N' Ba câu A, B và C đều sai', N'A', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (107, N'BIO2020', 1, N'Đất, nước, không khí, âm thanh, ánh sáng…thuộc thành phần môi trường nào:', N'', N'', N' Môi trường tự nhiên', N' Môi trường nhân tạo', N' Môi trường xã hội', N' Ba câu A, B và C đều sai', N'A', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (108, N'BIO2020', 1, N'Năng lượng mặt trời thuộc dạng tài nguyên nào:', N'', N'', N' Tài nguyên vĩnh viễn', N' Tài nguyên có thể phục hồi', N' Tài nguyên không thể phục hồi', N' Tài nguyên hữu hạn', N'A', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (109, N'BIO2020', 1, N'Môi trường có chức năng cơ bản, bao gồm: (1) Là nơi cư trú cho người và các loài sinh vật, (2) Là nơi cung cấp các nguồn tài nguyên, (3) Là nơi cung cấp các nguồn thông tin, và (4)………………………', N'', N'', N' “Là không gian sống cho sinh vật”', N' “Là nơi chứa đựng phế thải”', N' “Là nơi cung cấp nguồn nguyên liệu”', N' “Là nơi cung cấp nguồn nhiên liệu”', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (110, N'BIO2020', 1, N'Dạng tài nguyên nào sau đây không phải là tài nguyên có thể phục hồi:', N'', N'', N' Tài nguyên nước ngọt', N' Tài nguyên sinh vật', N' Tài nguyên khoáng sản', N' Tài nguyên đất phì nhiêu', N'C', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (111, N'BIO2020', 1, N'Năng lượng gió thuộc dạng tài nguyên nào:', N'', N'', N' Tài nguyên vĩnh viễn', N' Tài nguyên có thể phục hồi', N' Tài nguyên không thể phục hồi', N' Tài nguyên hữu hạn', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (112, N'BIO2020', 1, N'Đất phì nhiêu thuộc dạng tài nguyên nào:', N'', N'', N' Tài nguyên vĩnh viễn', N' Tài nguyên có thể phục hồi', N' Tài nguyên không thể phục hồi', N' Tài nguyên vô hạn', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (113, N'BIO2020', 1, N'Chọn phát biểu đúng nhất về mối quan hệ giữa môi trường và tài nguyên:', N'', N'', N' Môi trường mang lại lợi ích cho con người và sản sinh giá trị kinh tế', N' Tài nguyên mang lại lợi ích cho con người và sản sinh giá trị kinh tế', N' Môi trường không mang lại lợi ích cho con người và không sản sinh giá trị kinh tế', N' Tài nguyên không mang lại lợi ích cho con người và không sản sinh giá trị kinh tế', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (114, N'BIO2020', 1, N'Dạng tài nguyên nào sau đây là tài nguyên tái tạo', N'', N'', N' Than đá', N' Dầu mỏ', N' Khí đốt', N' Ba câu A, B và C đều sai', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (115, N'BIO2020', 1, N'Chọn phát biểu không phù hợp theo nhận thức mới về môi trường', N'', N'', N' Trái Đất có nguồn tài nguyên vô hạn', N' Tái chế và ưu tiên sử dụng tài nguyên tái tạo được', N' Con người phải hợp tác với thiên nhiên', N' Ba câu A, B và C đều sai', N'A', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (116, N'BIO2020', 1, N'Các nhà máy sản xuất, các khu nhà ở, các công viên…thuộc thành phần môi trường nào:', N'', N'', N' Môi trường tự nhiên', N' Môi trường nhân tạo', N' Môi trường xã hội', N' Ba câu A, B và C đều sai', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (117, N'BIO2020', 1, N'Dạng tài nguyên nào sau đây không phải là tài nguyên tái tạo', N'', N'', N' Năng lượng mặt trời', N' Năng lượng gió', N' Năng lượng sinh khối', N' Ba câu A, B và C đều sai', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (118, N'BIO2020', 1, N'Nhiên liệu hóa thạch thuộc dạng tài nguyên nào', N'', N'', N' Tài nguyên vĩnh viễn', N' Tài nguyên có thể phục hồi', N' Tài nguyên không thể phục hồi', N' Tài nguyên vô hạn', N'C', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (119, N'BIO2020', 1, N'Giới hạn của sinh quyển bao gồm:', N'', N'', N' Thạch quyển (sâu 2-3km từ mặt đất)', N' Khí quyển (cao 8-10km từ mặt đất)', N' Thủy quyển', N' Ba câu A, B và C đều đúng', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (120, N'BIO2020', 1, N'Năng suất của hệ sinh thái là:', N'', N'', N' Tổng số năng lượng đươc hấp thu bởi sự quang hợp, kể cả phần năng lượng tiêu thụ cho hoạt động hô hấp để duy trì sự sống', N' Lượng chất sống đã được sinh vật hấp thu và tích lũy trên một diện tích nhất định trong một thời gian nhất định', N' Mức độ tích lũy chất hữu cơ trong cơ thể sinh vật trừ đi phần đã sử dụng cho hô hấp', N' Lượng chất hữu cơ được tích lũy của các sinh vật dị dưỡng trong hệ sinh thái', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (121, N'BIO2020', 1, N'Cân bằng sinh thái động nhân tạo là:', N'', N'', N' Một hệ sinh thái nông nghiệp', N' Hệ sinh thái sông Sài Gòn – Đồng Nai, với việc xây dựng Hồ Trị An', N' Hệ sinh thái sông Cửu Long và Biển Hồ', N' Hệ sinh thái vi sinh vật trong bể bùn hoạt tính', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (122, N'BIO2020', 1, N'Chu trình nào sau đây là chu trình không tuần hoàn:', N'', N'', N' Chu trình cacbon', N' Chu trình nitơ', N' Chu trình phốt pho', N' Chu trình lưu huỳnh', N'C', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (123, N'BIO2020', 1, N'Sinh vật phân hủy là', N'', N'', N' Tảo', N' Nấm', N' Vi khuẩn', N' Tất cả câu trên đều đúng', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (124, N'BIO2020', 1, N'Chuỗi thức ăn là:', N'', N'', N' Là chuỗi trong đó các sinh vật sử dụng phân và xác sinh vật làm thức ăn', N' Là chuỗi bắt đầu từ thực vật đến động vật ăn thực vật, đến động vật ăn động vật', N' Là chuỗi tiếp diễn bằng cách một số sinh vật này dùng những sinh vật khác làm thức ăn', N' Là chuỗi chuyển hóa năng lượng từ sinh vật sản xuất, đến sinh vật tiêu thụ, đến sinh vật phân hủy', N'D', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (125, N'BIO2020', 1, N'Vòng tuần hoàn vật chất khác với dòng năng lượng vì:', N'', N'', N' Vật chất được các thành phần hệ sinh thái tái sử dụng còn năng lượng không được sử dụng lại', N' Vòng tuần hoàn vật chất là vòng kín còn dòng năng lượng là vòng hở', N' Vòng tuần hoàn vật chất là chu trình tuần hoàn còn dòng năng lượng là chu trình không tuần hoàn', N' Vòng tuần hoàn vật chất và dòng năng lượng không thể diễn ra đồng thời', N'A', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (126, N'BIO2020', 1, N'Quần thể sinh vật là', N'', N'', N' Tập hợp các cá thể cùng loài', N' Tập hợp các cá thể khác loài', N' Các nhóm sinh vật khác loài', N' Các nhóm sinh vật cùng chung sống', N'A', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (127, N'BIO2020', 1, N'Sinh vật tiêu thụ là:', N'', N'', N' Sinh vật ăn cỏ', N' Sinh vật ăn thịt', N' Sinh vật ăn xác chết', N' Động vật', N'D', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (128, N'BIO2020', 1, N'Cân bằng sinh thái động tự nhiên là:', N'', N'', N' Sự cân bằng của hệ sinh thái dưới các tác động của các nhân tố tự nhiên trong môi trường', N' Sự cân bằng của hệ sinh thái dưới các tác động của môi trường tự nhiên, không có sự điều khiển của con người', N' Sự cân bằng của hệ sinh thái dưới các tác động của các nhân tố tự nhiên môi trường, không có sự tác động của con người', N' Tất cả các câu trên đều đúng', N'C', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (129, N'BIO2020', 1, N'Diễn thế sinh thái là do', N'', N'', N' Sự thay đổi của môi trường', N' Quy luật của sự tiến hóa', N' Nguyên lý của sự cân bằng sinh thái', N' Cơ chế tự điều chỉnh', N'A', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (130, N'BIO2020', 1, N'Định luật tối thiểu (Liebig) được phát biểu:', N'', N'', N' Một số yếu tố sinh thái cần phải có mặt ở mức tối thiểu để sinh vật có thể tồn tại', N' Một số sinh vật cần một lượng tối thiểu các nguyên tố vi lượng để tồn tại', N' Sinh vật nào cũng cần có các yếu tố sinh thái để tồn tại dù ở mức tối thiểu', N' Đối với sinh vật yếu tố sinh thái cần phải đủ ở mức tối thiểu để sinh vật tồn tại', N'A', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (131, N'BIO2020', 1, N'Để duy trì sự cân bằng sinh thái cần phải', N'', N'', N' Kiểm soát dòng năng lượng đi qua hệ thống', N' Kiểm soát mối quan hệ giữa các thành phần trong hệ thống', N' Duy trì cấu trúc chuỗi và lưới thức ăn', N' Duy trì sự cân bằng giữa các thành phần trong hệ thống', N'B', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (132, N'BIO2020', 1, N'Tháp năng lượng là:', N'', N'', N' Kiểu tháp sinh thái thể hiện tổ chức và chưc năng của quần xã', N' Cách biểu thị cấu trúc dinh dưỡng bằng đơn vị năng lượng', N' Cách biểu thị cấu trúc dinh dưỡng bằng biểu đồ dạng tháp', N' Thể hiện tốc độ di chuyển của khối lượng thức ăn trong chuỗi thức ăn', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (133, N'BIO2020', 1, N'Sinh vật sản xuất là', N'', N'', N' Thực vật', N' Vi sinh vật', N' Các tổ chức sinh vật sử dụng năng lượng mặt trời làm nguyên liệu đầu vào', N' Thực vật và vi sinh vật', N'C', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (134, N'BIO2020', 1, N'Chu trình sinh địa hóa trong hệ sinh thái là:', N'', N'', N' Các nguyên tố hóa học tuần hoàn trong sinh quyển từ môi trường ngoài vào cơ thể sinh vật, từ cơ thể sinh vật ra môi trường ngoài', N' Các nguyên tố cơ bản vật chất tuần hoàn trong sinh quyển theo các con đường đặc trưng', N' Các nguyên tố hóa học tuần hoàn từ sinh vật này sang sinh vật khác, rồi từ cơ thể sinh vật ra ngoài môi trường', N' Các nguyên tố hóa học tuần hoàn từ môi trường ngoài vào cơ thể sinh vật, từ sinh vật này sang sinh vật khác, rồi từ cơ thể sinh vật ra ngoài môi trường', N'D', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (135, N'BIO2020', 1, N'Định luật giới hạn sinh thái (Shelford) được phát biểu:', N'', N'', N' Các loài sinh vật có giới hạn sinh thái rộng thì phân bố rộng và ngược lại', N' Mỗi sinh vật có một giới hạn sinh thái nhất định đối với từng yếu tố sinh thái', N' Các yếu tố sinh thái đều có một giới hạn nhất định cho từng loài sinh vật đặc trưng', N' Một số yếu tố sinh thái cần phải có mặt với một giới hạn nhất định để sinh vật tồn tại và phát triển', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (136, N'BIO2020', 1, N'Hệ sinh thái môi trường chưa hoàn chỉnh:', N'', N'', N' Hệ sinh thái trong lòng đại dương', N' Hệ sinh thái biển sâu', N' Hệ sinh thái thiếu sinh vật SX', N' Hệ sinh thái thiếu sinh vật phân hủy', N'C', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (137, N'BIO2020', 1, N'Chọn khái niệm chính xác nhất:', N'', N'', N' Hệ sinh thái là tập hợp các quần xã sinh vật và môi trường mà nó đang sinh sống', N' Hệ sinh thái là một hệ thống các quần xã sinh vật cùng các điều kiện môi trường bao quanh nó', N' Hệ sinh thái là một tập hợp động vật, thực vật và vi sinh vật cùng tương tác với nhau và với các thành phần khác của môi trường', N' Hệ sinh thái bao gồm các quần xã sinh vật cùng chung sống trong một sinh cảnh chịu tác động lẫn nhau và tác động của môi trường xung quanh', N'C', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (138, N'BIO2020', 1, N'Tháp dinh dưỡng là:', N'', N'', N' Các bậc dinh dưỡng sắp xếp từ thấp đến cao', N' Là tháp sinh khối', N' Là tháp năng lượng', N' Là mối quan hệ giữa dinh dưỡng từ sinh vật sản xuất đến sinh vật tiêu thụ', N'A', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (139, N'BIO2020', 1, N'Cấu trúc dinh dưỡng của hệ sinh thái bao gồm:', N'', N'', N' Chuỗi thức ăn, năng lượng và các yếu tố khác', N' Sinh vật sản xuất, sinh vật tiêu thụ bậc 1, sinh vật tiêu thụ bậc 2', N' Các bậc dinh dưỡng nối tiếp nhau', N' Sinh vật tự dưỡng và sinh vật dị dưỡng', N'C', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (140, N'BIO2020', 1, N'Mỗi sinh vật cần có các điều kiện cơ bản để tồn tại:', N'', N'', N' Nơi ở và ổ sinh thái', N' Nơi ở và dinh dưỡng', N' Nơi ở và sinh sản', N' Dinh dưỡng và sinh sản', N'A', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (141, N'BIO2020', 1, N'Ý nghĩa của chuỗi thức ăn đối với hệ sinh thái:', N'', N'', N' Tạo nên mạng lưới thức ăn', N' Phân bố và chuyển hóa năng lượng', N' Kiểm soát sự biến động của quần thể', N' Giữ cân bằng của hệ sinh thái', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (142, N'BIO2020', 1, N'Yếu tố sinh thái là:', N'', N'', N' Những yếu tố cấu trúc nên môi trường xung quanh sinh vật như: ánh sáng, nhiệt độ, thức ăn….', N' Các yếu tố môi trường có tác động trực tiếp hay gián tiếp lên đời sống sinh vật', N' Các yếu tố vô sinh và hữu sinh tác động lên sinh vật', N' Các yếu tố vô sinh và hữu sinh tác động lẫn nhau', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (143, N'BIO2020', 1, N'Để đạt được sự cân bằng sinh thái cần phải:', N'', N'', N' Thông qua các mâu thuẫn và cạnh tranh', N' Có các yếu tố sinh trưởng và suy giảm', N' Hệ thống luôn luôn tự điều chỉnh', N' Hình thái cân bằng co giãn', N'C', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (144, N'BIO2020', 1, N'Một hệ sinh thái cân bằng là', N'', N'', N' Cấu trúc các loài không thay đổi', N' Số lượng loài và số lượng cá thể trong một loài ổn định', N' Tổng số loài tương đối ổn định', N' Ít phụ thuộc vào các thay đổi từ ngoài hệ thống', N'A', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (145, N'BIO2020', 1, N'Rừng nguyên sinh ở Việt Nam chiếm:', N'', N'', N' 18% tổng diện tích rừng', N' 12% tổng diện tích rừng', N' 10% tổng diện tích rừng', N' 8% tổng diện tích rừng', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (146, N'BIO2020', 1, N'Vai trò cơ bản của trồng rừng:', N'', N'', N' Bảo vệ nguồn nước', N' Bảo vệ đất', N' Chống xói mòn', N' Khai thác gỗ', N'D', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (147, N'BIO2020', 1, N'Để phát triển bền vững tài nguyên rừng cần thực hiện:', N'', N'', N' Trồng và bảo vệ rừng – Xóa đói giảm nghèo – Chống du canh du cư – Hợp tác quốc tế', N' Phát triển kinh tế - Phát triển cộng đồng địa phương có rừng – Hỗ trợ tài chính cho dân cư nghèo', N' Thay đổi ý thức tiêu thụ sản phẩm rừng – Chống du canh du cư – Phát triển kinh tế địa phương', N' Trồng và bảo vệ rừng – Thay đổi ý thức tiêu thụ sản phẩm – Xóa đói giảm nghèo – Hợp tác quốc tế', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (148, N'BIO2020', 1, N'Vai trò của rừng ngập mặn:', N'', N'', N' Giữ đất', N' Mở rộng bờ biển', N' Chống xâm nhập mặn', N' Điều hòa khí hậu', N'B', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (149, N'BIO2020', 1, N'Tỷ lệ mất rừng trên thế giới diễn ra mạnh mẽ nhất ở:', N'', N'', N' Châu Á', N' Châu Phi', N' Châu Mỹ La Tinh', N' Châu Âu', N'C', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (150, N'BIO2020', 1, N'Rừng nhằm hạn chế thiên tai lũ lụt, gió bão, bảo vệ nguồn nước, bảo vệ đất, chống xói mòn, góp phần bảo vệ môi trường:', N'', N'', N' Rừng đặc dụng', N' Rừng phòng hộ', N' Rừng sản xuất', N' Khu dự trữ sinh quyển', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (151, N'BIO2020', 1, N'Hậu quả của sự mất rừng là:', N'', N'', N' Ô nhiễm môi trường', N' Sự giảm đa dạng sinh học', N' Khủng hoảng hệ sinh thái', N' Lũ lụt và hạn hán gia tăng', N'C', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (152, N'BIO2020', 1, N'Diện tích rừng bình quân đầu người trên thế giới là:', N'', N'', N' 0,3 ha/người', N' 0,4 ha/người', N' 0,5 ha/người', N' 0,6 ha/người', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (153, N'BIO2020', 1, N'Nguyên nhân gây mất đất rừng ở Việt Nam:', N'', N'', N' Đốt rừng làm rẫy', N' Du canh du cư', N' Ô nhiễm môi trường', N' Xói lở đất', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (154, N'BIO2020', 1, N'Khoa học khuyến cáo, mỗi quốc gia nên duy trì tỷ lệ diện tích lãnh thổ có rừng che phủ là:', N'', N'', N' 40%', N' 45%', N' 50%', N' 65%', N'B', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (155, N'BIO2020', 1, N'Nguyên nhân gây suy giảm diện tích rừng là:', N'', N'', N' Chiến tranh', N' Khai thác quá mức', N' Ô nhiễm môi trường', N' Cháy rừng', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (156, N'BIO2020', 1, N'Vai trò chính của rừng phòng hộ là:', N'', N'', N' Bảo vệ môi trường', N' Khai thác gỗ', N' Du lịch', N' Bảo tồn', N'A', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (157, N'BIO2020', 1, N'Loại rừng nào được ưu tiên trồng ở Việt Nam:', N'', N'', N' Rừng phòng hộ', N' Rừng đặc dụng', N' Rừng sản xuất', N' Rừng ngập mặn', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (158, N'BIO2020', 1, N'Rừng chủ yếu để bảo tồn thiên nhiên, bảo vệ nguồn gen động vật và thực vật, hệ sinh thái rừng của quốc gia, là khu vực nghiên cứu khoa học và du lịch là:', N'', N'', N' Rừng đặc dụng', N' Rừng phòng hộ', N' Rừng sản xuất', N' Khu dự trữ sinh quyển', N'A', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (159, N'BIO2020', 1, N'Nguyên nhân thu hẹp diện tích rừng ở Việt Nam:', N'', N'', N' Đốt nương làm rẫy – Khai thác củi gỗ - Phát triển cơ sở hạ tầng – Cháy rừng', N' Lấy đất làm nông nghiệp – Khai thác củi gỗ - Xây dựng, giao thông – Chiến tranh', N' Khai thác quá mức – Mở mang đô thị - Ô nhiễm môi trường – Cháy rừng', N' Chuyển đổi cơ cấu nông nghiệp – Xây dựng cơ sở hạ tầng – Cháy rừng – Chiến tranh', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (160, N'BIO2020', 1, N'Rừng nguyên sinh ở Việt Nam phân bố ở:', N'', N'', N' Rừng Cúc Phương', N' Rừng Nam Cát Tiên', N' Rừng Bạch Mã', N' Rừng U Minh', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (161, N'BIO2020', 1, N'Rừng ngập mặn là:', N'', N'', N' Rừng phòng hộ', N' Rừng đặc dụng', N' Rừng nguyên sinh', N' Rừng thứ sinh', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (162, N'BIO2020', 1, N'Diện tích rừng ở Việt Nam chủ yếu phân bố ở:', N'', N'', N' Tây Bắc', N' Tây Nguyên', N' Tây Nam Bộ', N' Đông Nam Bộ', N'A', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (163, N'BIO2020', 1, N'Làm thế nào để tăng độ che phủ của rừng:', N'', N'', N' Trồng cây gây rừng', N' Phát triển khu bảo tồn', N' Giao đất giao rừng cho người dân', N' Chống ô nhiễm môi trường', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (164, N'BIO2020', 1, N'Các kiểu rừng nào là phổ biến ở Việt Nam:', N'', N'', N' Rừng là rộng thường xanh ở nhiệt đới', N' Rừng thưa cây họ dầu', N' Rừng ngập mặn', N' Rừng tre nứa', N'C', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (165, N'BIO2020', 1, N'Để bảo vệ rừng cần tiến hành các giải pháp nào sau đây:', N'', N'', N' Khai thác hợp lý – Hạn chế ô nhiễm môi trường – Phòng chống cháy rừng', N' Bảo vệ đa dạng sinh học – Giao đất, giao đất cho dân – Chống cháy rừng', N' Khai thác hợp lý – Bảo vệ đa dạng sinh học – Hạn chế ô nhiễm môi trường', N' Giao dất, giao rừng cho dân – Bảo vệ đa dạng sinh học – Hạn chế ô nhiễm môi trường', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (166, N'BIO2020', 1, N'Rừng ngập mặn ở Việt Nam chủ yếu phân bố ở:', N'', N'', N' Cần Giờ', N' Vũng Tàu', N' Cà Mau', N' Thái Bình', N'C', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (167, N'BIO2020', 1, N'Luật bảo vệ và phát triển rừng Việt Nam ưu tiên:', N'', N'', N' Trồng rừng và phủ xanh đất trống đồi trọc', N' Hạn chế khai hoang đất rừng, di dân tự do', N' Xây dựng vườn quốc gia và khu bảo tồn', N' Đóng cửa rừng tự nhiên', N'A', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (168, N'BIO2020', 1, N'Rừng là hệ sinh thái tự nhiên có vai trò:', N'', N'', N' Bảo vệ đa dạng sinh học, cung cấp oxi, cung cấp nguyên liệu, nhiên liệu, vật liệu, lương thực và thực phẩm', N' Tạo ra độ đa dạng sinh học, làm sạch bầu khí quyển, cung cấp gỗ, phòng hộ đầu nguồn, tạo cảnh quan', N' Là nơi ở cho các loài động vật, tiêu thụ và tích lũy CO2, bảo vệ đất, bảo vệ nước, điều hòa khí hậu', N' Duy trì đa dạng sinh học cung cấp nguyên liệu, tạo vi khí hậu và là cơ sở bảo tồn văn hóa địa phương', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (169, N'BIO2020', 1, N'Vai trò quan trọng nhất của rừng là:', N'', N'', N' Bảo vệ đất', N' Cung cấp vật liệu', N' Điều hòa khí hậu', N' Bảo vệ đa dạng sinh học', N'C', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (170, N'BIO2020', 1, N'Dầu hỏa được hình thành từ:', N'', N'', N' Sự phân giải của các thực vật phù du (phytoplankton) và động vật phù du (zooplankton) chết lắng động ở đáy biển', N' Sự lắng đọng của dương xỉ, thạch tùng khổng lồ của thời kì cách dây 320-380 triệu năm', N' Sự lắng đọng của các loại động vật giáp xác ở đáy biển', N' Sự tích lũy than đá trong đất cách đây trên 300 triệu năm', N'A', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (171, N'BIO2020', 1, N'Câu nào sau đây chưa đúng: Nguyên nhân sử dụng hợp lý nguồn tài nguyên khoáng sản:', N'', N'', N' Khi khai thác khoáng sản phải tích cả chi phí thiệt hại cho tương lai', N' Tái chế phế thải', N' Sự dụng năng lượng sạch/tài nguyên được tái tạo', N' Chuyển sang khai thác thật nhiều các tài nguyên có giá trị thấp', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (172, N'BIO2020', 1, N'Câu nào sau đây chưa đúng: Các giải pháp bảo vệ môi trường trong khai thác khoáng sản:', N'', N'', N' Quan trắc thường xuyên tác động môi trường của hoạt động khai thác khoáng sản', N' Lập báo cáo đánh giá tác động môi trường cho dự án khai thác khoáng sản', N' Chú trọng bảo tồn các khoáng sản quý', N' Thực hiện các công trình giảm thiểu ô nhiễm tại nguồn', N'C', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (173, N'BIO2020', 1, N'Ở Việt Nam, dầu mỏ và khí đốt tập trung ở khu vực nào?', N'', N'', N' Trung du và miền núi', N' Ven biển và thềm lục địa', N' Đồng bằng châu thổ', N' Đất ngập nước', N'B', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (174, N'BIO2020', 1, N'Các nước Trung Đông chiếm bao nhiêu % lượng giàu mỏ của Thế giới:', N'', N'', N' 50%', N' 55%', N' 60%', N' 65%', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (175, N'BIO2020', 1, N'Câu nào sau đây chưa đúng: Hiện tượng khan hiếm khoáng sản xảy ra là vì?', N'', N'', N' Trữ lượng khoáng sản giới hạn', N' Quá trình hình thánh khoảng sản lâu dài', N' Khai thác không hợp lý', N' Các nguồn thải làm ô nhiễm khoáng sản', N'D', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (176, N'BIO2020', 1, N'Tài nguyên khoáng sản bao gồm các loại tài nguyên nào?', N'', N'', N' Kim loại, phi kim', N' Kim loại, phi kim, khoáng sản cháy', N' Kim loại, phi kim, dầu mỏ, khí đốt', N' Kim loại, phi kim, than bùn, dầu mỏ, khí đốt', N'B', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (177, N'BIO2020', 1, N'Việc khai thác khoáng sản bất hợp lý sẽ không gây ra:', N'', N'', N' Ô nhiễm nguồn nước', N' Biến đổi khí hậu toàn cầu', N' Ô nhiễm bầu không khí do bụi và CH4', N' Xâm nhập mặn làm ô nhiễm môi trường đất', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (178, N'BIO2020', 1, N'Than đá được hình thành từ:', N'', N'', N' Sự phân giải của các thực vật phù du (phytoplankton) và động vật phù du (zooplankton) chết lắng động ở đáy biển', N' Sự lắng đọng của dương xỉ, thạch tùng khổng lồ của thời kì cách dây 320-380 triệu năm', N' Sự lắng đọng của các loại động vật giáp xác ở đáy biển', N' Sự tích lũy than đá trong đất cách đây trên 300 triệu năm', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (179, N'BIO2020', 1, N'Hiện nay lượng nước sử dụng trên đầu người cao nhất ở khu vực:', N'', N'', N' Châu Phi', N' Châu Âu và Mỹ', N' Châu Á', N' Châu Mỹ Latinh', N'B', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (180, N'BIO2020', 1, N'Thế nào là nước bị ô nhiễm', N'', N'', N' Là nước chứa nồng độ các chất ô nhiễm vượt quá mức an toàn cho phép', N' Là nước chứa nhiều vi trùng và các tác nhân gây bệnh khác', N' Là nước chứa nhiều váng bọt', N' Là nước rất đục', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (181, N'BIO2020', 1, N'Tổng số lượng sông, kênh ở Việt Nam vào khoảng:', N'', N'', N' 860', N' 1360', N' 1860', N' 2360', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (182, N'BIO2020', 1, N'Để bảo vệ tài nguyên nước, chúng ta cần:', N'', N'', N' Giữ gìn và phát triển thảm thực vật', N' Sử dụng hợp lý, tránh lãng phí tài nguyên nước', N' Bảo vệ môi trường các thủy vực', N' Ba câu A, B và C đều đúng', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (183, N'BIO2020', 1, N'Nước bao phủ bề mặt Trái Đất với tỷ lệ diện tích là', N'', N'', N' 51%', N' 61%', N' 71%', N' 81%', N'C', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (184, N'BIO2020', 1, N'Hiện nay lượng nước sử dụng trên đầu người thấp nhất ở khu vực:', N'', N'', N' Châu Phi', N' Châu Âu', N' Châu Á', N' Mỹ', N'A', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (185, N'BIO2020', 1, N'Thành phần nước trên Trái Đất bao gồm:', N'', N'', N' 91% nước mặn, 2% nước dạng băng, 7% nước ngọt', N' 93% nước mặn, 2% nước dạng băng, 5% nước ngọt', N' 95% nước mặn, 2% nước dạng băng, 3% nước ngọt', N' 97% nước mặn, 2% nước dạng băng, 1% nước ngọt', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (186, N'BIO2020', 1, N'Các tác nhân hóa học gây ô nhiễm môi trường nước không bao gồm:', N'', N'', N' Kim loại nặng', N' Chất dinh dưỡng N, P', N' Vi sinh vật gây bệnh', N' Thuốc nhiễm màu', N'C', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (187, N'BIO2020', 1, N'Vai trò của nước là:', N'', N'', N' Điều hòa khí hậu trên hành tinh', N' Duy trì sự sống cho Trái Đất', N' Cung cấp nước cho sinh hoạt, nông nghiệp, công nghiệp, giao thông…..', N' Ba câu A, B và C đều đúng', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (188, N'BIO2020', 1, N'Khi hàm lượng oxy hòa tan (DO) của nguồn nước giảm thấp chứng tỏ:', N'', N'', N' Nguồn nước bị ô nhiễm bởi các chất hữu cơ', N' Quá trình quang hợp được tăng cường', N' Hệ thủy sinh sinh trưởng phát triển tốt', N' Quá trình phân hủy hiểu khí chiếm ưu thế', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (189, N'BIO2020', 1, N'Phú dưỡng là do sự gia tăng hàm lượng chất nào trong nước:', N'', N'', N' Fe, Mn', N' N, P', N' Ca, Mg', N' Cl, F', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (190, N'BIO2020', 1, N'Để đánh giá mức độ ô nhiễm sinh học nguồn nước, người ta dựa vào:', N'', N'', N' Chỉ số pH', N' DO, BOD, COD', N' Độ đục', N' Chỉ số Coliform', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (191, N'BIO2020', 1, N'Các tác nhân hóa học gây ô nhiễm môi trường nước không bao gồm:', N'', N'', N' Kim loại nặng', N' Nhiệt độ', N' Hóa chất bảo vệ thực vật', N' Dầu mỡ thải', N'B', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (192, N'BIO2020', 1, N'Ở giai đoạn kết thúc của quá trình phú dưỡng hóa, thủy vực có các đặc điểm sau:', N'', N'', N' Thừa oxy do quá trình phân hủy xác thực vật phù du', N' Tăng tính đa dạng hệ sinh thái thủy vực', N' Tăng cường quá trình tự làm sạch', N' Quá trình phân hủy kị khí chiếm ưu thế', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (193, N'BIO2020', 1, N'Lượng nước ngọt con người có thể sử dụng chiếm:', N'', N'', N' 5-7% lượng nước trên Trái Đất', N' 3-5% lượng nước trên Trái Đất', N' 1-3% lượng nước trên Trái Đất', N' <1% lượng nước trên Trái Đất', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (194, N'BIO2020', 1, N'Đặc tính nước thải sinh hoạt không bao gồm:', N'', N'', N' Chứa nhiều chất hữu cơ', N' Chứa Nitơ, Phôtpho', N' Các chất khó phân hủy sinh học', N' Mang các mầm bệnh', N'C', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (195, N'BIO2020', 1, N'Thành phần nước trong cơ thể người chiếm tỷ lệ khối lượng là:', N'', N'', N' 60%', N' 70%', N' 80%', N' 90%', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (196, N'BIO2020', 1, N'Các tác nhân sinh học gây ô nhiễm môi trường nước bao gồm:', N'', N'', N' Kim loại nặng', N' Chất tẩy rửa', N' Thuốc trừ sâu', N' Vi khuẩn gây bệnh', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (197, N'BIO2020', 1, N'Khả năng tự làm sạch của nguồn nước phụ thuộc vào:', N'', N'', N' Quá trình xáo trộn', N' Quá trình khoáng hóa', N' Quá trình lắng đọng', N' Ba câu A, B và C đều đúng', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (198, N'BIO2020', 1, N'Để đánh giá mức độ ô nhiễm hữu cơ nguồn nước, người ta dựa vào:', N'', N'', N' Chỉ số pH', N' DO, BOD, COD', N' Độ đục', N' Chỉ số Coliform', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (199, N'BIO2020', 1, N'Tỷ lệ lượng nước mà hệ thống sông ngòi ở Việt Nam nhận được từ các con song nước ngoài chảy vào:', N'', N'', N' 30%', N' 45%', N' 60%', N' 75%', N'C', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (200, N'BIO2020', 1, N'Hiện tượng xảy ra khi các thủy vực kín tiếp nhận một lượng lớn các chất Nitơ và Phốt pho, được định nghĩa là:', N'', N'', N' Hiện tượng axit hóa', N' Hiện tượng kiềm hóa', N' Hiện tượng phú dưỡng hóa', N' Hiện tượng mặn hóa', N'C', 3)
GO
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (201, N'BIO2020', 1, N'Mật độ sông suối ở Việt Nam trung bình là:', N'', N'', N' 0.6 km/km2', N' 1.6 km/km2', N' 2.6 km/km2', N' 3.6 km/km2', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (202, N'BIO2020', 1, N'Nguyên nhân làm suy giảm nguồn nước ngầm là:', N'', N'', N' Khai thác cạn kiệt nước dưới đất', N' Bê tông hóa mặt đất', N' Tàn phá thảm thực vật', N' Ba câu A, B và C đều đúng', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (203, N'BIO2020', 1, N'Biển Việt Nam mang nhiều tài nguyên quý giá, với chiều dài đường bờ biển là:', N'', N'', N' 1260km', N' 2260km', N' 3260km', N' 4260km', N'C', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (204, N'BIO2020', 1, N'Đặc điểm sông ngòi Việt Nam là:', N'', N'', N' Phần lớn bắt nguồn từ nước ngoài', N' Mật độ sông suối dày đặc', N' Phát triển nhiều công trình thủy lợi, thủy điện', N' Ba câu A, B và C đều đúng', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (205, N'BIO2020', 1, N'Các nhân tố vật lý gây ô nhiễm môi trường nước bao gồm:', N'', N'', N' Nhiệt độ', N' Dầu mỡ thải', N' Vi sinh vật gây bệnh', N' Ba câu A, B và C đều đúng', N'A', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (206, N'BIO2020', 1, N'Nêu thứ tự của lớp vỏ Trái Đất thứ tự từ bên ngoài vào:', N'', N'', N' Lớp Manti Vỏ Trái Đất Nhân Trái Đất', N' Vỏ Trái Đất Nhân Trái Đất Lớp Manti', N' Lớp Manti Nhân Trái Đất Vỏ Trái Đất', N' Vỏ Trái Đất Lớp Manti Nhân Trái Đất', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (207, N'BIO2020', 1, N'Các yếu tố hình thành đất bao gồm:', N'', N'', N' Đá mẹ, khí hậu, thời gian', N' Khí hậu, địa hình, sinh vật', N' Sinh vật, địa hình, đá mẹ', N' Ba câu A, B và C đều đúng', N'D', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (208, N'BIO2020', 1, N'Nguyên nhân nào suy thoái tài nguyên đất:', N'', N'', N' Mưa acid', N' Biến đổi khí hậu', N' Canh tác độc canh', N' Ba câu A, B và C đều đúng', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (209, N'BIO2020', 1, N'Giải pháp nào không góp phần cải thiện chất lượng đất:', N'', N'', N' Sử dụng phân bón vi sinh', N' Sử dụng thiên địch trong phòng trừ sâu bệnh', N' Xây dựng các đập thủy điện', N' Ba câu A, B và C đều đúng', N'C', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (210, N'BIO2020', 1, N'Các quá trình hình thành đất từ đá bao gồm:', N'', N'', N' Phong hóa vật lý, phong hóa hóa học', N' Phong hóa hóa học, phong hóa sinh học', N' Phong hóa sinh học, phong hóa vật lý', N' Ba câu A, B và C đều đúng', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (211, N'BIO2020', 1, N'Tài nguyên đất ở Việt Nam có khoảng:', N'', N'', N' 13 triệu ha', N' 23 triệu ha', N' 33 triệu ha', N' 43 triệu ha', N'C', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (212, N'BIO2020', 1, N'[VD]Hoạt động nào của con người làm suy thoái tài nguyên đất:', N'', N'', N' Sử dụng hóa chất bảo vệ thực vật', N' Triển khai mô hình Thực hành nông nghiệp tốt (GAP)', N' Áp dụng chương trình Quản lý dịch hại tổng hợp (IPM)', N' Ba câu A, B và C đều đúng', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (213, N'BIO2020', 1, N'Nguyên nhân nào làm suy thoái tài nguyên đất:', N'', N'', N' Giảm độ che phủ rừng', N' Sử dụng nhiều phân bón hóa học', N' Ô nhiễm không khí', N' Ba câu A, B và C đều đúng', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (214, N'BIO2020', 1, N'Đất bao phủ về mặt Trái Đất với tỷ lệ diện tích là:', N'', N'', N' 49%', N' 39%', N' 29%', N' 19%', N'C', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (215, N'BIO2020', 1, N'Hoạt động bón phân chuồng, phân bắc chưa ủ hoai mục, thải bỏ chất thải y tế, chất sinh hoạt….vào môi trường đất dẫn đến:', N'', N'', N' Đất bị chai hóa', N' Đất bị phèn hóa', N' Đất bị kiệt mùn', N' Đất bị ô nhiễm vi sinh', N'D', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (216, N'BIO2020', 1, N'Biến đổi khí hậu gây ra những hậu quả', N'', N'', N' Làm tăng mực nước biển', N' Ảnh hưởng đến nông nghiệp', N' Làm gia tăng các cơn bão', N' A, B, C đều đúng', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (217, N'BIO2020', 1, N'Tại sao vấn đề kiểm soát vi sinh vật gây bệnh trong không khí lại là một trong những vấn đề khó khăn nhất của ngành vệ sinh môi trường?', N'', N'', N' Do lượng vi sinh vật nhiều nên khó kiểm soát', N' Do vi sinh vật tồn tại lâu trong không khí có khả năng chống chịu cao', N' Cả A và B đều đúng', N' Cả A và B đều sai', N'C', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (218, N'BIO2020', 1, N'Khí CH4 đóng góp bao nhiêu % vào hiệu ứng nhà kính', N'', N'', N' 10%', N' 16%', N' 20%', N' 25%', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (219, N'BIO2020', 1, N'Nếu vẫn giữ lượng phát thải CO2 như hiện nay, năm 2050, mực nước biển sẽ dâng lên bao nhiêu?', N'', N'', N' 33cm', N' 50cm', N' 70cm', N' 90cm', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (220, N'BIO2020', 1, N'O2 là chất ô nhiễm sơ cấp hay thứ cấp?', N'', N'', N' Sơ cấp', N' Thứ cấp', N' Cả A và B đều đúng', N' Cả A và B đều sai', N'A', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (221, N'BIO2020', 1, N'Dựa vào trạng thái vật lý, có thể phân loại chất ô nhiễm trong không khí làm bao nhiêu loại?', N'', N'', N' Khí, Hơi, Hạt', N' Khí, Bụi, Hơi', N' Hơi, Bụi, Lỏng', N' Khí, Hạt, Lỏng', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (222, N'BIO2020', 1, N'Khí quyển bao gồm những tầng nào?', N'', N'', N' Đối lưu, Bình lưu, Trung lưu, Nhiệt, Điện li', N' Đối lưu, Ozone, Trung lưu, Nhiệt, Điện li', N' Đối lưu, Trung lưu, Thượng lưu', N' Đối lưu, Trung lưu, Nhiệt, Điện li', N'A', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (223, N'BIO2020', 1, N'Khí CFC đóng góp bao nhiêu % vào hiệu ứng nhà kính', N'', N'', N' 20%', N' 30%', N' 40%', N' 50%', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (224, N'BIO2020', 1, N'Độ cao của tầng nhiệt là bao nhiêu?', N'', N'', N' 180 – 1000km', N' 100 – 1500km', N' 90 – 500km', N' 250 – 1200km', N'C', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (225, N'BIO2020', 1, N'Khí quyển gồm bao nhiêu tầng:', N'', N'', N' 2', N' 3', N' 4', N' 5', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (226, N'BIO2020', 1, N'Độ cao của tầng trung lưu là bao nhiêu?', N'', N'', N' 50 – 100km', N' 50 – 90km', N' 20 – 180km', N' 30 – 250km', N'B', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (227, N'BIO2020', 1, N'Nitrogen chiếm bao nhiêu % khí quyển về thể tích', N'', N'', N' 70%', N' 70,9%', N' 78%', N' 79,9%', N'C', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (228, N'BIO2020', 1, N'N2O có khả năng hấp thu bức xạ gấp bao nhiêu lần so với CO2?', N'', N'', N' 120 lần', N' 206 lần', N' 450 lần', N' 801 lần', N'B', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (229, N'BIO2020', 1, N'Trong tầng bình lưu, nồng độ ozone đạt tối đa ở độ cao nào?', N'', N'', N' 10 – 20km', N' 20 – 25km', N' 30 – 35km', N' 40 – 45km', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (230, N'BIO2020', 1, N'Trong môi trường không khí, mật độ vi sinh vật gây bệnh tăng cao khi:', N'', N'', N' Nhiệt độ môi trường cao, ánh sáng nhiều', N' Gió nhiều', N' Mưa nhiều', N' Cả 3 đều sai', N'C', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (231, N'BIO2020', 1, N'Sắp xếp các tầng khí quyển từ thấp lên cao;', N'', N'', N' Bình lưu, Đối lưu, Trung lưu, Nhiệt, Điện li', N' Đối lưu, Bình lưu, Trung lưu, Nhiệt, Điện li', N' Nhiệt, Điện li, Bình lưu, Trung lưu, Đối lưu', N' Điện li, Nhiệt, Bình lưu, Trung lưu, Đối lưu', N'B', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (232, N'BIO2020', 1, N'Nếu vẫn giữ lượng phát thải CO2 như hiện nay, năm 2100, mực nước biển sẽ dâng lên bao nhiêu?', N'', N'', N' 1m', N' 1,2m', N' 1,5m', N' 2m', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (233, N'BIO2020', 1, N'Độ cao của tầng đối lưu là bao nhiêu?', N'', N'', N' 0 – 10km', N' 0 – 15km', N' 0 – 20km', N' 0 – 25km', N'A', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (234, N'BIO2020', 1, N'Khí N2O đóng góp bao nhiêu % vào hiệu ứng nhà kính', N'', N'', N' 2%', N' 4%', N' 6%', N' 8%', N'C', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (235, N'BIO2020', 1, N'Xét về hàm lượng, khí nào là nguyên nhân chính gây hiệu ứng nhà kính?', N'', N'', N' CH4', N' CO2', N' NH3', N' H2O', N'B', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (236, N'BIO2020', 1, N'Mưa acid gây ra do nguyên nhân nào?', N'', N'', N' CO2, SO2, NO2', N' SO2, NO2', N' NH3, SO2, NO2', N' CO, CO2, NO, NO2, SO2', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (237, N'BIO2020', 1, N'Tại sao mưa acid làm cây trồng không phát triển được?', N'', N'', N' Thấm vào than, lá cây, hủy hoại cây', N' Thấm vào đất làm đất chai cứng', N' Cản trở quá trình quang hợp, tan chất dinh dưỡng trong đất, ngăn cản quá trình cố định đạm của vi sinh vật', N' Cản trở quá trình quang hợp, cây không hấp thu được án sáng mặt trời', N'C', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (238, N'BIO2020', 1, N'NO2 là chất ô nhiễm sơ cấp hay thứ cấp?', N'', N'', N' Sơ cấp', N' Thứ cấp', N' Cả A và B đều đúng', N' Cả A và B đều sai', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (239, N'BIO2020', 1, N'Nhiệt độ trung bình trong tầng đối lưu là bao nhiêu?', N'', N'', N' 10oC', N' 15oC', N' 20oC', N' 25oC', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (240, N'BIO2020', 1, N'Khói, tro bụi của núi lửa là nguồn ô nhiễm nào?', N'', N'', N' Tự nhiên', N' Nhân tạo', N' Cả A và B đều đúng', N' Cả A và B đều sai', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (241, N'BIO2020', 1, N'Khí CO2 đóng góp bao nhiêu % vào hiệu ứng nhà kính', N'', N'', N' 25%', N' 35%', N' 50%', N' 60%', N'C', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (242, N'BIO2020', 1, N'Nguyên nhân chính gây ra lỗ thủng tầng ozone', N'', N'', N' CFCs', N' CO2', N' CH4', N' NH3', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (243, N'BIO2020', 1, N'Tia UV tác động làm bật gốc Cl của khí CFC gây ra thủng tầng ozone có bước song bao nhiêu?', N'', N'', N' <150nm', N' <230nm', N' <280nm', N' <330nm', N'B', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (244, N'BIO2020', 1, N'Độ cao của tầng không gian là bao nhiêu?', N'', N'', N' >500km', N' >1000km', N' >1500km', N' >2000km', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (245, N'BIO2020', 1, N'Oxy chiếm bao nhiêu % khí quyển về thể tích', N'', N'', N' 20%', N' 20,9%', N' 30%', N' 29,9%', N'B', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (246, N'BIO2020', 1, N'Độ cao của tầng bình lưu là bao nhiêu?', N'', N'', N' 10 – 50 km', N' 15 – 35km', N' 20 – 50km', N' 10 – 35km', N'A', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (247, N'BIO2020', 1, N'Khí quyển giúp ngăn các bức xạ có bước sóng?', N'', N'', N' <300nm', N' <480nm', N' <500nm', N' <600nm', N'A', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (248, N'BIO2020', 1, N'Kỷ lục thấp nhất của tầng ozone được ghi nhận vào năm 1994 là bao nhiêu?', N'', N'', N' 88 DU', N' 128 DU', N' 258 DU', N' 288 DU', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (249, N'BIO2020', 1, N'Nước nào thải ra khí nhà kính nhiều nhất thế giới:', N'', N'', N' Mỹ', N' Trung Quốc', N' Nga', N' Úc', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (250, N'BIO2020', 1, N'Kích cỡ hạt bụi dao động trong khoảng nào?', N'', N'', N' 0,1 đến 50 micromet', N' 0,1 đến 100 micromet', N' 0,1 đến 150 micromet', N' 0,1 đến 200 micromet', N'B', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (251, N'BIO2020', 1, N'H2SO4 là chất ô nhiễm sơ cấp hay thứ cấp?', N'', N'', N' Sơ cấp', N' Thứ cấp', N' Cả A và B đều đúng', N' Cả A và B đều sai', N'B', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (252, N'BIO2020', 1, N'Sự tồn tại của sinh vật trong không khí phụ thuộc vào', N'', N'', N' Điều kiện thời tiết', N' Tốc độ gió hướng gió', N' Môi trường đất bên dưới', N' Cả 3 đều đúng', N'D', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (253, N'BIO2020', 1, N'CO2 phát sinh từ hoạt động nào?', N'', N'', N' Đốt cháy các nhiên liệu hóa thạch', N' Từ các hoạt động sinh hoạt của con người', N' Từ các hoạt động nông nghiệp', N' A, B, C đều đúng', N'D', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (254, N'BIO2020', 1, N'Nồng độ ozone lớn nhất trong tầng bình lưu là', N'', N'', N' 1ppm', N' 3ppm', N' 5ppm', N' 7ppm', N'D', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (255, N'BIO2020', 1, N'CFC12 có khả năng hấp thu bức xạ gấp bao nhiêu lần so với CO2?', N'', N'', N' 12400 lần', N' 17000 lần', N' 18500 lần', N' 20100 lần', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (256, N'BIO2020', 1, N'CH4 có khả năng hấp thu bức xạ gấp bao nhiêu lần so với CO2?', N'', N'', N' 12 lần', N' 21 lần', N' 24 lần', N' 50 lần', N'B', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (257, N'BIO2020', 1, N'Nhiệt độ của tầng trung lưu giảm tối đa là bao nhiêu?', N'', N'', N' -50oC', N' -100oC', N' -150oC', N' -200oC', N'B', 3)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (258, N'BIO2020', 1, N'Lỗ thủng tầng ozone được phát hiện trầm trọng nhất ở khu vực nào?', N'', N'', N' Nam Cực', N' Bắc Cực', N' Châu Mỹ', N' Châu Phi', N'A', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (259, N'BIO2020', 1, N'HNO3 là chất ô nhiễm sơ cấp hay thứ cấp?', N'', N'', N' Sơ cấp', N' Thứ cấp', N' Cả A và B đều đúng', N' Cả A và B đều sai', N'B', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (260, N'BIO2020', 1, N'Nguồn ô nhiễm sơ cấp chuyển thành thứ cấp là do tác động của:', N'', N'', N' Các loại côn trùng', N' Gió, các sinh vật, độ bền vững của khí quyển', N' Gió, mưa, không khí', N' Bản chất của các chất ô nhiễm', N'C', 4)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (261, N'BIO2020', 1, N'Nhiệt độ gia tăng từ 1850-1899 tới 2001-2005 là bao nhiêu?', N'', N'', N' 0,52oC', N' 0,76oC', N' 0,87oC', N' 1,21oC', N'B', 1)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (262, N'BIO2020', 1, N'CFC11 có khả năng hấp thu bức xạ gấp bao nhiêu lần so với CO2?', N'', N'', N' 12400 lần', N' 15800 lần', N' 21200 lần', N' 25300 lần', N'A', 2)
INSERT [dbo].[Cauhoi] ([ma_CH], [ma_Bode], [loai], [nd_CH], [img_CH], [aud_CH], [TL_1], [TL_2], [TL_3], [TL_4], [DA], [dokho]) VALUES (263, N'BIO2020', 1, N'Mưa acid không gây ra các hậu quả sau:', N'', N'', N' Gây ảnh hưởng đến công trình xây dựng', N' Làm giảm đa dạng sinh học của rừng', N' Làm thay đổi môi trường không khí', N' Làm suy giảm số lượng gấu Bắc Cực', N'D', 2)
GO
INSERT [dbo].[Gacthi] ([ma_KT], [ma_GV]) VALUES (N'20201A2105', N'GV1')
INSERT [dbo].[Gacthi] ([ma_KT], [ma_GV]) VALUES (N'20201A2105', N'GV2')
GO
INSERT [dbo].[Giaovien] ([ma_GV], [ten_GV], [ngaysinh], [img_GV], [username]) VALUES (N'GV1', N'Lê Thị Hoàng Ngọc', CAST(N'2000-03-14T00:00:00.000' AS DateTime), N'', N'giaovien1')
INSERT [dbo].[Giaovien] ([ma_GV], [ten_GV], [ngaysinh], [img_GV], [username]) VALUES (N'GV2', N'ff', CAST(N'2000-01-01T00:00:00.000' AS DateTime), N'DataSet/tui-giay-kraft-trang.jpg', N'giaovien2')
GO
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118051', N'Nguyễn Thanh Hào', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118051')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118214', N'Nguyễn Bình An', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118214')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS2021211831', N'Đỗ Vân Anh', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS2021211831')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118316', N'Nguyễn Ngọc Anh', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118316')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118323', N'Lương Thị Linh Chi', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118323')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118330', N'Dương Đức Cương', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118330')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118336', N'Ngô Vũ Khánh Duy', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118336')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118343', N'Lê Doãn Thành Đạt', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118343')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118352', N'Vũ Minh Đạt', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118352')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118358', N'Phạm Hoài Giang', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118358')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS2021211838', N'Đỗ Việt Anh', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS2021211838')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118411', N'Vũ Thị Minh Hằng', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118411')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118421', N'Phạm Thị Mai Hoa', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118421')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118432', N'Nguyễn Đình Nam Khánh', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118432')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118439', N'Lê Thế Lâm', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118439')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118446', N'Chu Phương Mai', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118446')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS2021211845', N'Vũ Thị Minh Hằng', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS2021211845')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118453', N'Phạm Tuấn Minh', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118453')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118459', N'Nguyễn Thị Yến Nhi', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118459')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118511', N'Trần Ngọc QuỳnhAnh', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118511')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118518', N'Phạm Thị ThuHường', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS20212118518')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118534', N'Lâm Đỗ Kim Anh', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS20212118534')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS2021211855', N'Bùi Xuân Lâm Phong', CAST(N'2000-05-26T00:00:00.000' AS DateTime), N'', N'0601', N'HS2021211855')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS2021211871', N'Nguyễn Ngọc Anh', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS2021211871')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118718', N'Nguyễn Tuấn Anh', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS20212118718')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118724', N'Trần Đức Anh', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS20212118724')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118730', N'Tô Tùng Dương', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS20212118730')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118745', N'Bùi Tuấn Dũng', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS20212118745')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118753', N'Bùi Hiền Dịu', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS20212118753')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118815', N'Đinh Công Đạt', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS20212118815')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118821', N'Bùi Thế Hiệp', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS20212118821')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118828', N'Nguyễn Minh Đức', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS20212118828')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118833', N'Lê Thị Lan', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS20212118833')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118839', N'Bùi Thị Xuân Mai', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS20212118839')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118849', N'Lê Thị Lan', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS20212118849')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118854', N'Phan Thị Thanh Nga', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS20212118854')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS2021211887', N'Bùi Phúc ĐanDuyên', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS2021211887')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS2021211890', N'Nguyễn Thị Mai', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS2021211890')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS20212118913', N'Đỗ Thu Ngân', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS20212118913')
INSERT [dbo].[Hocsinh] ([ma_HS], [ten_HS], [ngaysinh], [img_HS], [ma_Lop], [username]) VALUES (N'HS2021211895', N'Đặng Hà My', CAST(N'2011-05-12T00:00:00.000' AS DateTime), N'', N'0602', N'HS2021211895')
GO
INSERT [dbo].[Khoi] ([ma_Khoi], [ten_Khoi]) VALUES (N'K6', N'Khối 6')
INSERT [dbo].[Khoi] ([ma_Khoi], [ten_Khoi]) VALUES (N'K7', N'Khối 7')
INSERT [dbo].[Khoi] ([ma_Khoi], [ten_Khoi]) VALUES (N'K8', N'Khối 8')
INSERT [dbo].[Khoi] ([ma_Khoi], [ten_Khoi]) VALUES (N'K9', N'Khối 9')
GO
INSERT [dbo].[Kythi] ([ma_KT], [ten_KT], [ngaythi], [tg_Lambai], [tg_Batdau], [tg_Ketthuc], [sl_CH], [ma_MH]) VALUES (N'20201A2105', N'Kiểm tra học kì 1A Sinh học', CAST(N'2021-06-15T00:00:00.000' AS DateTime), 30, CAST(N'06:30:00' AS Time), CAST(N'07:00:00' AS Time), 30, N'BIO')
GO
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0601', N'6/01', N'K6')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0602', N'6/02', N'K6')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0603', N'6/03', N'K6')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0604', N'6/04', N'K6')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0605', N'6/05', N'K6')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0606', N'6/06', N'K6')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0607', N'6/07', N'K6')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0608', N'6/08', N'K6')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0609', N'6/09', N'K6')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0610', N'6/10', N'K6')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0701', N'7/01', N'K7')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0702', N'7/02', N'K7')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0703', N'7/03', N'K7')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0704', N'7/04', N'K7')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0705', N'7/05', N'K7')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0706', N'7/06', N'K7')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0707', N'7/07', N'K7')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0708', N'7/08', N'K7')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0709', N'7/09', N'K7')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0710', N'7/10', N'K7')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0801', N'8/01', N'K8')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0802', N'8/02', N'K8')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0803', N'8/03', N'K8')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0804', N'8/04', N'K8')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0805', N'8/05', N'K8')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0806', N'8/06', N'K8')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0807', N'8/07', N'K8')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0808', N'8/08', N'K8')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0809', N'8/09', N'K8')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0810', N'8/10', N'K8')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0901', N'9/01', N'K9')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0902', N'9/02', N'K9')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0903', N'9/03', N'K9')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0904', N'9/04', N'K9')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0905', N'9/05', N'K9')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0906', N'9/06', N'K9')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0907', N'9/07', N'K9')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0908', N'9/08', N'K9')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0909', N'9/09', N'K9')
INSERT [dbo].[Lop] ([ma_Lop], [ten_Lop], [ma_Khoi]) VALUES (N'0910', N'9/10', N'K9')
GO
INSERT [dbo].[Made] ([ma_De], [ten_Made], [ma_CHde], [ma_Bode]) VALUES (N'BIO2020123', N'123', N'src/XLS/BIO2020123.xls', N'BIO2020')
INSERT [dbo].[Made] ([ma_De], [ten_Made], [ma_CHde], [ma_Bode]) VALUES (N'BIO2020246', N'216', N'src/XLS/BIO2020246.xls', N'BIO2020')
INSERT [dbo].[Made] ([ma_De], [ten_Made], [ma_CHde], [ma_Bode]) VALUES (N'ENG2020123', N'123', N'src/XLS/ENG2020123.xls', N'ENG2020')
INSERT [dbo].[Made] ([ma_De], [ten_Made], [ma_CHde], [ma_Bode]) VALUES (N'ENG2020246', N'246', N'src/XLS/ENG2020246.xls', N'ENG2020')
GO
INSERT [dbo].[Monhoc] ([ma_MH], [ten_MH]) VALUES (N'BIO', N'Sinh học')
INSERT [dbo].[Monhoc] ([ma_MH], [ten_MH]) VALUES (N'ENG', N'Tiếng Anh')
INSERT [dbo].[Monhoc] ([ma_MH], [ten_MH]) VALUES (N'GEO', N'Địa lý')
INSERT [dbo].[Monhoc] ([ma_MH], [ten_MH]) VALUES (N'HIS', N'Lịch sử')
INSERT [dbo].[Monhoc] ([ma_MH], [ten_MH]) VALUES (N'INT', N'Tin học')
INSERT [dbo].[Monhoc] ([ma_MH], [ten_MH]) VALUES (N'MAT', N'Toán')
INSERT [dbo].[Monhoc] ([ma_MH], [ten_MH]) VALUES (N'PHS', N'Vật lý')
GO
INSERT [dbo].[Quyen] ([ma_Quyen], [ten_Quyen]) VALUES (1, N'Admin     ')
INSERT [dbo].[Quyen] ([ma_Quyen], [ten_Quyen]) VALUES (2, N'Giao vien ')
INSERT [dbo].[Quyen] ([ma_Quyen], [ten_Quyen]) VALUES (3, N'Hoc sinh  ')
GO
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'admin1', N'123@abc', 1, 1)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'admin2', N'123@abc', 1, 1)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'admin4', N'123@abc', 1, 1)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'giaovien1', N'123@abc', 1, 2)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'giaovien2', N'123@abc', 1, 2)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS11', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118051', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118214', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS2021211831', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118316', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118323', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118330', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118336', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118343', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118352', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118358', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS2021211838', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118411', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118421', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118432', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118439', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118446', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS2021211845', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118453', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118459', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118511', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118518', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118534', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS2021211855', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS2021211871', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118718', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118724', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118730', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118745', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118753', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118815', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118821', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118828', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118833', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118839', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118849', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118854', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS2021211887', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS2021211890', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS20212118913', N'123@abc', 1, 3)
INSERT [dbo].[Taikhoan] ([username], [passwords], [trangthai], [ma_Quyen]) VALUES (N'HS2021211895', N'123@abc', 1, 3)
GO
INSERT [dbo].[Thisinh] ([ma_KT], [ma_HS]) VALUES (N'20201A2105', N'HS20212118051')
INSERT [dbo].[Thisinh] ([ma_KT], [ma_HS]) VALUES (N'20201A2105', N'HS20212118214')
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Relationship9]    Script Date: 5/22/2021 8:33:05 AM ******/
CREATE NONCLUSTERED INDEX [IX_Relationship9] ON [dbo].[Admin]
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Relationship26]    Script Date: 5/22/2021 8:33:05 AM ******/
CREATE NONCLUSTERED INDEX [IX_Relationship26] ON [dbo].[Bode]
(
	[ma_KT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Relationship4]    Script Date: 5/22/2021 8:33:05 AM ******/
CREATE NONCLUSTERED INDEX [IX_Relationship4] ON [dbo].[Bode]
(
	[ma_MH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Relationship8]    Script Date: 5/22/2021 8:33:05 AM ******/
CREATE NONCLUSTERED INDEX [IX_Relationship8] ON [dbo].[Giaovien]
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Relationship10]    Script Date: 5/22/2021 8:33:05 AM ******/
CREATE NONCLUSTERED INDEX [IX_Relationship10] ON [dbo].[Hocsinh]
(
	[ma_Lop] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Relationship7]    Script Date: 5/22/2021 8:33:05 AM ******/
CREATE NONCLUSTERED INDEX [IX_Relationship7] ON [dbo].[Hocsinh]
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Relationship27]    Script Date: 5/22/2021 8:33:05 AM ******/
CREATE NONCLUSTERED INDEX [IX_Relationship27] ON [dbo].[Ketqua]
(
	[ma_HS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Relationship7]    Script Date: 5/22/2021 8:33:05 AM ******/
CREATE NONCLUSTERED INDEX [IX_Relationship7] ON [dbo].[Ketqua]
(
	[ma_KT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Relationship5]    Script Date: 5/22/2021 8:33:05 AM ******/
CREATE NONCLUSTERED INDEX [IX_Relationship5] ON [dbo].[Kythi]
(
	[ma_MH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Relationship9]    Script Date: 5/22/2021 8:33:05 AM ******/
CREATE NONCLUSTERED INDEX [IX_Relationship9] ON [dbo].[Lop]
(
	[ma_Khoi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Relationship3]    Script Date: 5/22/2021 8:33:05 AM ******/
CREATE NONCLUSTERED INDEX [IX_Relationship3] ON [dbo].[Made]
(
	[ma_Bode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_Relationship6]    Script Date: 5/22/2021 8:33:05 AM ******/
CREATE NONCLUSTERED INDEX [IX_Relationship6] ON [dbo].[Taikhoan]
(
	[ma_Quyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Admin]  WITH CHECK ADD  CONSTRAINT [Ad_TK] FOREIGN KEY([username])
REFERENCES [dbo].[Taikhoan] ([username])
GO
ALTER TABLE [dbo].[Admin] CHECK CONSTRAINT [Ad_TK]
GO
ALTER TABLE [dbo].[Baithi]  WITH CHECK ADD  CONSTRAINT [KQ_TL] FOREIGN KEY([ma_KQ])
REFERENCES [dbo].[Ketqua] ([ma_KQ])
GO
ALTER TABLE [dbo].[Baithi] CHECK CONSTRAINT [KQ_TL]
GO
ALTER TABLE [dbo].[Bode]  WITH CHECK ADD  CONSTRAINT [Bode_KT] FOREIGN KEY([ma_KT])
REFERENCES [dbo].[Kythi] ([ma_KT])
GO
ALTER TABLE [dbo].[Bode] CHECK CONSTRAINT [Bode_KT]
GO
ALTER TABLE [dbo].[Bode]  WITH CHECK ADD  CONSTRAINT [NH_Bode] FOREIGN KEY([ma_MH])
REFERENCES [dbo].[Monhoc] ([ma_MH])
GO
ALTER TABLE [dbo].[Bode] CHECK CONSTRAINT [NH_Bode]
GO
ALTER TABLE [dbo].[Cauhoi]  WITH CHECK ADD  CONSTRAINT [FK_Cauhoi_Bode] FOREIGN KEY([ma_Bode])
REFERENCES [dbo].[Bode] ([ma_Bode])
GO
ALTER TABLE [dbo].[Cauhoi] CHECK CONSTRAINT [FK_Cauhoi_Bode]
GO
ALTER TABLE [dbo].[Gacthi]  WITH CHECK ADD  CONSTRAINT [FK_Gacthi_Giaovien] FOREIGN KEY([ma_GV])
REFERENCES [dbo].[Giaovien] ([ma_GV])
GO
ALTER TABLE [dbo].[Gacthi] CHECK CONSTRAINT [FK_Gacthi_Giaovien]
GO
ALTER TABLE [dbo].[Gacthi]  WITH CHECK ADD  CONSTRAINT [FK_Gacthi_Kythi] FOREIGN KEY([ma_KT])
REFERENCES [dbo].[Kythi] ([ma_KT])
GO
ALTER TABLE [dbo].[Gacthi] CHECK CONSTRAINT [FK_Gacthi_Kythi]
GO
ALTER TABLE [dbo].[Giaovien]  WITH CHECK ADD  CONSTRAINT [GV_TK] FOREIGN KEY([username])
REFERENCES [dbo].[Taikhoan] ([username])
GO
ALTER TABLE [dbo].[Giaovien] CHECK CONSTRAINT [GV_TK]
GO
ALTER TABLE [dbo].[Hocsinh]  WITH CHECK ADD  CONSTRAINT [HS_Lop] FOREIGN KEY([ma_Lop])
REFERENCES [dbo].[Lop] ([ma_Lop])
GO
ALTER TABLE [dbo].[Hocsinh] CHECK CONSTRAINT [HS_Lop]
GO
ALTER TABLE [dbo].[Hocsinh]  WITH CHECK ADD  CONSTRAINT [HS_TK] FOREIGN KEY([username])
REFERENCES [dbo].[Taikhoan] ([username])
GO
ALTER TABLE [dbo].[Hocsinh] CHECK CONSTRAINT [HS_TK]
GO
ALTER TABLE [dbo].[Ketqua]  WITH CHECK ADD  CONSTRAINT [KQ_HS] FOREIGN KEY([ma_HS])
REFERENCES [dbo].[Hocsinh] ([ma_HS])
GO
ALTER TABLE [dbo].[Ketqua] CHECK CONSTRAINT [KQ_HS]
GO
ALTER TABLE [dbo].[Ketqua]  WITH CHECK ADD  CONSTRAINT [KQ_KT] FOREIGN KEY([ma_KT])
REFERENCES [dbo].[Kythi] ([ma_KT])
GO
ALTER TABLE [dbo].[Ketqua] CHECK CONSTRAINT [KQ_KT]
GO
ALTER TABLE [dbo].[Kythi]  WITH CHECK ADD  CONSTRAINT [MH_KT] FOREIGN KEY([ma_MH])
REFERENCES [dbo].[Monhoc] ([ma_MH])
GO
ALTER TABLE [dbo].[Kythi] CHECK CONSTRAINT [MH_KT]
GO
ALTER TABLE [dbo].[Lop]  WITH CHECK ADD  CONSTRAINT [Khoi_Lop] FOREIGN KEY([ma_Khoi])
REFERENCES [dbo].[Khoi] ([ma_Khoi])
GO
ALTER TABLE [dbo].[Lop] CHECK CONSTRAINT [Khoi_Lop]
GO
ALTER TABLE [dbo].[Made]  WITH CHECK ADD  CONSTRAINT [MH_Made] FOREIGN KEY([ma_Bode])
REFERENCES [dbo].[Bode] ([ma_Bode])
GO
ALTER TABLE [dbo].[Made] CHECK CONSTRAINT [MH_Made]
GO
ALTER TABLE [dbo].[Taikhoan]  WITH CHECK ADD  CONSTRAINT [TK_ Quyen] FOREIGN KEY([ma_Quyen])
REFERENCES [dbo].[Quyen] ([ma_Quyen])
GO
ALTER TABLE [dbo].[Taikhoan] CHECK CONSTRAINT [TK_ Quyen]
GO
ALTER TABLE [dbo].[Thisinh]  WITH CHECK ADD  CONSTRAINT [FK_Thisinh_Hocsinh] FOREIGN KEY([ma_HS])
REFERENCES [dbo].[Hocsinh] ([ma_HS])
GO
ALTER TABLE [dbo].[Thisinh] CHECK CONSTRAINT [FK_Thisinh_Hocsinh]
GO
ALTER TABLE [dbo].[Thisinh]  WITH CHECK ADD  CONSTRAINT [FK_Thisinh_Kythi] FOREIGN KEY([ma_KT])
REFERENCES [dbo].[Kythi] ([ma_KT])
GO
ALTER TABLE [dbo].[Thisinh] CHECK CONSTRAINT [FK_Thisinh_Kythi]
GO
USE [master]
GO
ALTER DATABASE [TTN] SET  READ_WRITE 
GO

USE [master]
GO
/****** Object:  Database [clinica]    Script Date: 23/02/2024 16:30:55 ******/
CREATE DATABASE [clinica]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'clinica', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\clinica.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'clinica_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\clinica_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [clinica] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [clinica].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [clinica] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [clinica] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [clinica] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [clinica] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [clinica] SET ARITHABORT OFF 
GO
ALTER DATABASE [clinica] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [clinica] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [clinica] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [clinica] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [clinica] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [clinica] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [clinica] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [clinica] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [clinica] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [clinica] SET  DISABLE_BROKER 
GO
ALTER DATABASE [clinica] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [clinica] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [clinica] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [clinica] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [clinica] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [clinica] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [clinica] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [clinica] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [clinica] SET  MULTI_USER 
GO
ALTER DATABASE [clinica] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [clinica] SET DB_CHAINING OFF 
GO
ALTER DATABASE [clinica] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [clinica] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [clinica] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [clinica] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [clinica] SET QUERY_STORE = ON
GO
ALTER DATABASE [clinica] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [clinica]
GO
/****** Object:  Table [dbo].[doctor]    Script Date: 23/02/2024 16:30:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[doctor](
	[id_doctor] [int] IDENTITY(1,1) NOT NULL,
	[id_especialidad] [int] NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellido] [varchar](50) NOT NULL,
	[codigo_colegiatura] [varchar](50) NOT NULL,
	[sueldo] [decimal](18, 2) NULL,
	[fecha_nacimiento] [datetime] NULL,
	[estado] [bit] NOT NULL,
 CONSTRAINT [PK_doctor] PRIMARY KEY CLUSTERED 
(
	[id_doctor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[especialidad]    Script Date: 23/02/2024 16:30:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[especialidad](
	[id_especialidad] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
	[activo] [bit] NULL,
 CONSTRAINT [PK_especialidad] PRIMARY KEY CLUSTERED 
(
	[id_especialidad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[doctor]  WITH CHECK ADD  CONSTRAINT [FK_doctor_especialidad] FOREIGN KEY([id_especialidad])
REFERENCES [dbo].[especialidad] ([id_especialidad])
GO
ALTER TABLE [dbo].[doctor] CHECK CONSTRAINT [FK_doctor_especialidad]
GO
/****** Object:  StoredProcedure [dbo].[SP_ActualizarDoctor]    Script Date: 23/02/2024 16:30:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE   PROCEDURE [dbo].[SP_ActualizarDoctor]
(	
	@P_id INT,
	@P_id_especialidad INT,
	@P_nombre varchar(50),
	@P_apellido varchar(50),
	@P_codigo_colegiatura varchar(50),
	@P_sueldo Decimal(18,2),
	@P_fecha_nacimiento Datetime
)
AS
BEGIN
	UPDATE [doctor]
	SET
		[id_especialidad] = @P_id_especialidad,
		[nombre] = @P_nombre,
		[apellido] = @P_apellido,
		[codigo_colegiatura] = @P_codigo_colegiatura,
		[sueldo] = @P_sueldo,
		[fecha_nacimiento] = @P_fecha_nacimiento 
	WHERE 
		id_doctor = @P_id;

END
GO
/****** Object:  StoredProcedure [dbo].[SP_CrearDoctor]    Script Date: 23/02/2024 16:30:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[SP_CrearDoctor]
(
     @P_id_especialidad int,
	 @P_nombre varchar(50),
	 @P_apellido varchar(50),
	 @P_codigo_colegiatura varchar(50),
	 @P_sueldo Decimal(18,2),
	 @P_fecha_nacimiento Datetime
)
AS
BEGIN
	INSERT INTO doctor(
		[id_especialidad],
		[nombre], 
		[apellido], 
		[codigo_colegiatura], 
		[sueldo], 
		[fecha_nacimiento], 
		[estado]
	) 
	OUTPUT Inserted.id_doctor
	values (
		@P_id_especialidad,
		@P_nombre, 
		@P_apellido, 
		@P_codigo_colegiatura, 
		@P_sueldo, 
		@P_fecha_nacimiento, 
		1
		);

	--SELECT @result_procedure = 'SUCCESS';
	--SELECT * FROM doctor WHERE id = SCOPE_IDENTITY();

END
GO
/****** Object:  StoredProcedure [dbo].[SP_EliminarDoctor]    Script Date: 23/02/2024 16:30:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[SP_EliminarDoctor]
(
     @P_id INT
)
AS
BEGIN
	UPDATE [doctor]
	SET
		[estado] = 0
	WHERE 
		id_doctor = @P_id;

END
GO
/****** Object:  StoredProcedure [dbo].[SP_ListarDoctores]    Script Date: 23/02/2024 16:30:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[SP_ListarDoctores]
AS
BEGIN
	select 
		doc.[id_doctor],
		doc.[nombre] as nombre_doctor,
		doc.[apellido],
		esp.[id_especialidad],
		esp.[nombre] as nombre_especialidad,
		doc.[codigo_colegiatura],
		doc.[sueldo],
		doc.[fecha_nacimiento],
		doc.[estado]
	from 
		doctor doc inner join especialidad esp
	on 
		doc.[id_especialidad] = esp.[id_especialidad]
	where 
		doc.[estado] = 1;

END
GO
/****** Object:  StoredProcedure [dbo].[SP_ListarDoctoresPorNombre]    Script Date: 23/02/2024 16:30:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE   PROCEDURE [dbo].[SP_ListarDoctoresPorNombre]
(
     @P_nombre varchar(50)
)
AS
BEGIN
	SELECT 
		esp.nombre as nombre_especialidad
		,doc.id_doctor
		,doc.nombre as nombre_doctor
		,doc.apellido
		,doc.codigo_colegiatura
		,doc.sueldo
		,doc.estado
	FROM 
		doctor doc inner join especialidad esp
	ON 
		doc.[id_especialidad] = esp.[id_especialidad]
	where 
		doc.[estado] = 1 AND
		doc.nombre = @P_nombre;



END
GO
USE [master]
GO
ALTER DATABASE [clinica] SET  READ_WRITE 
GO

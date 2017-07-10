# WORK 
Spring boot/Hibernate Çalışma Projesi

## Build and Run
### Configuration 
Gerekli konfigürasyonlarınızı application.properties dosyasından yapınız(örneğn port değiştirme,veritabanı bağlantısı...)

### Prerequisites
[Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

[Maven](https://maven.apache.org/download.cgi)

[Spring Tool Suite](https://spring.io/tools/sts/all)



### For Spring Tool Suite/Eclipse
   File->İmport
               ->Existing Maven Projects add project
			   
## Usage

Projeyi localhost:9090 portundan çalıştırın(eğer port değişikliği isterse app.properties dosyasından değiştirebilirsiniz)

Proje başlangıcında her tablo için örnek 2 veri kaydı bulunmaktadır.(Loader class da görebilirisiniz)

Tablo yapılarını ve değişimlerini Spring boot içinde gömülü olan H2 vertanını localhost:9090/console çağırarak linkinden görebilirsiniz.

Proje ilk çalıştığında log da kayıtlı elemanlardan biri için delete işlemi yapılırsa hata alabilirsiniz. Tablo üzerinde veri girişinden sonra her eleman için Delete işlemi yapılabilir.

Yeni bir dependency için [siteyi](https://mvnrepository.com/) kullanabilirsiniz.

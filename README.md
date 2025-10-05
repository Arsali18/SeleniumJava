📘 README — Saucedemo E2E Test (Versi Sebelum Refactor)
🧩 Deskripsi Proyek

Proyek ini adalah automated test sederhana menggunakan Selenium WebDriver dan TestNG untuk melakukan pengujian end-to-end di situs SauceDemo
.
Test ini akan:

Membuka halaman login,

Melakukan login menggunakan akun demo,

Menambahkan produk ke keranjang,

Melakukan checkout,

Menyelesaikan pembelian hingga halaman konfirmasi.

⚙️ Prasyarat (Requirements)

Pastikan sudah menginstal hal-hal berikut:

| Komponen  | Versi minimum                 | Keterangan                                               |
| --------- | ----------------------------- | -------------------------------------------------------- |
| Java JDK  | 11 atau lebih baru            | Pastikan `java` dan `javac` sudah di PATH                |
| Maven     | 3.8+                          | Untuk manajemen dependensi dan menjalankan test          |
| Selenium  | 4.x                           | Diatur lewat `pom.xml`                                   |
| TestNG    | 7.x atau lebih baru           | Framework testing                                        |
| Browser   | Chrome / Firefox              | Browser untuk menjalankan test                           |
| WebDriver | Sesuai browser yang digunakan | `chromedriver` atau `geckodriver` harus tersedia di PATH |

📦 Dependensi Maven (pom.xml)

```xml
   <project xmlns="http://maven.apache.org/POM/4.0.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>saucedemo-test</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <!-- Selenium -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.21.0</version>
        </dependency>

        <!-- TestNG -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.10.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.1.2</version>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>testng.xml</suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

   ```

🚀 Menjalankan Test
1️⃣ Jalankan Langsung dari IDE

Buka TestCase.java, lalu klik Run → Run 'TestCase'
IDE seperti IntelliJ IDEA atau Eclipse akan menjalankan test melalui TestNG.

2️⃣ Jalankan dari Command Line (Maven)
mvn clean test


Pastikan geckodriver (untuk Firefox) atau chromedriver (untuk Chrome) sudah tersedia di PATH kamu.

🧪 Alur Test (Test Flow)

1.Test di TestCase.java melakukan langkah-langkah berikut:

2.Membuka browser (Firefox) dan membuka halaman https://www.saucedemo.com/

3.Mengisi field username dengan standard_user

4.Mengisi password dengan secret_sauce

5.Klik tombol Login

6.Menunggu halaman produk muncul

7.Klik tombol Add to Cart untuk produk “Sauce Labs Backpack”

8.Klik ikon Cart

9.Klik tombol Checkout

10.Mengisi form checkout dengan nama dan kode pos

11.Klik tombol Continue

12.Klik tombol Finish

13.Test selesai, browser ditutup
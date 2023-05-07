<<<<<<< HEAD
package BankaApp;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

class Kisi{
	private int tcKimlikNo;
	private String ad;
	private String soyad;
	private String email;
	private int telefonNumarasi;
	
	
	public Kisi(int tcKimlikNo,String ad,String soyad,String email,int telefonNumarasi) {
		this.setAd(ad); // YEREL DEĞİŞKENE THİS İLE PRAMETRELER AKTARİLİYOR.
		this.setSoyad(soyad);
		this.setEmail(email);
		this.setTelefonNumarasi(telefonNumarasi);
		this.setTcKimlikNo(tcKimlikNo);
	}
	


	public int getTcKimlikNo() { //private değişkenlere erişim için
		return tcKimlikNo;
	}


	public void setTcKimlikNo(int tcKimlikNo) { //private değişkenlere erişim için
		this.tcKimlikNo = tcKimlikNo;
	}


	public String getAd() {
		return ad;
	}


	public void setAd(String ad) {
		this.ad = ad;
	}


	public String getSoyad() {
		return soyad;
	}


	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getTelefonNumarasi() {
		return telefonNumarasi;
	}


	public void setTelefonNumarasi(int telefonNumarasi) {
		this.telefonNumarasi = telefonNumarasi;
	}


	

	
	//public to String {}
		
}

class BankaPersonel extends Kisi{
	private int personelID;
	ArrayList<Object> Musteriler = new ArrayList<>(); //Personel için array listler tanımlanmıştır
	public BankaPersonel(int tcKimlikNo,String ad, String soyad, String email, int telefonNumarasi, int personelID) {
		super(tcKimlikNo,ad, soyad, email, telefonNumarasi);
		this.personelID = personelID;
		
		 //System.out.println("PERSONELIN\nAd:"+ad+"\nSoyad:"+soyad+"\nTC:"+tcKimlikNo+"\nE-Mail:"+email+"\nTel:"+telefonNumarasi+"\nID:"+personelID); 
		 
	}
	public int getPersonelID() {
		return personelID;
	}

	public void setPersonelID(int personelID) {
		this.personelID = personelID;
	}


	
	
	//public to String {}
	
}

class Musteri extends Kisi{
	private int musteriNumarasi;
	static ArrayList<Object> hesaplar = new ArrayList<>(); //Musteri için hesaplar array listi
	static ArrayList<Object> krediKartlari = new ArrayList<>();//Musteri için kredi kartı array listi
	static ArrayList<Object> hesapTuru = new ArrayList<>(); //Musteri için hesap turu array listi
	
	public Musteri(int tcKimlikNo,String ad, String soyad, String email, int telefonNumarasi,int musteriNumarasi) {
		super(tcKimlikNo,ad, soyad, email, telefonNumarasi);
		this.setMusteriNumarasi(musteriNumarasi);
		//System.out.println("MUSTERININ\nAd:"+ad+"\nSoyad:"+soyad+"\nTC:"+tcKimlikNo+"\nE-Mail:"+email+"\nTel:"+telefonNumarasi+"\nID:"+musteriNumarasi);
		}
		
	void hesapEkle(int tcKimlikNo,int musteriNumarasi,String ad,String soyad, String email, int telefonNumarasi) { // Main fonksiyonundan hesap üretimi için hesap eklenin çağrılması yeterli
		int a;
		int b;
		String c;
		
		Random rand=new Random();
		Scanner input = new Scanner(System.in);
		System.out.println("\nAcmak istediginiz hesap turunu seciniz:\n1)Vadeli\n2)Vadesiz\n3)Yatırım\n--> ");
		a = input.nextInt();
		if (a==1) { // vadeli hesap kaydı işlemleri
			System.out.println("Vadeli hesabinizin Toplam Bakiyesini giriniz\n--> ");
			b = input.nextInt();
			System.out.println("Vadeli hesabinizinNe ne tur bir hesap olmasini istiyorsunuz Maas(1), Normal(2)\n--> ");
			c = input.next();
			Musteri.hesapTuru.add(c); //ARRAY LİSTE EKLEME YAPMA
			VadeliHesap vadeli1=new VadeliHesap(BankaHesap.iban,"Vadeli",rand.nextInt(2000)+1, 20, b,c);
			System.out.println("Vadeli hesbiniz, ibanina ve vadeli bakiyesine rastgele sayilar atanarak basari ile olusturulmustur ve musteri hesaplarina eklenmiştir");
			Musteri.hesaplar.add(vadeli1);
		}	
		
		else if(a==2) { //vadesiz hesap kaydı işlemleri
			System.out.println("Vadesiz hesabinizin Toplam Bakiyesini giriniz\n--> ");
			b = input.nextInt();
			System.out.println("Vadeli hesabinizinNe ne tur bir hesap olmasini istiyorsunuz Maas(1), Normal(2)\n--> ");
			c = input.next();
			Musteri.hesapTuru.add(c);
			VadesizHesap vadesiz1=new VadesizHesap(BankaHesap.iban, "Vadesiz", rand.nextInt(2000)+1, b, c);
			System.out.println("Vadeli hesbiniz, ibanina ve vadeli bakiyesine rastgele sayilar atanarak basari ile olusturulmustur ve musteri hesaplarina eklenmiştir");
			Musteri.hesaplar.add(vadesiz1);
		}
		else if(a==3) { // yatırım hesap kaydı işlemleri
			System.out.println("Yatirim hesabinizin Toplam Bakiyesini giriniz\n--> ");
			b = input.nextInt();
			System.out.println("Yatirim hesabinizinNe ne tur bir hesap olmasini istiyorsunuz Maas(1), Normal(2)\n--> ");
			c = input.next();
			Musteri.hesapTuru.add(c);
			YatirimHesap yatirim1=new YatirimHesap(19, "yatirmTuru: Bos", rand.nextInt(2000)+1,"Yatirim",BankaHesap.iban, b, c);
			System.out.println("Yatirim hesbiniz, ibanina ve vadeli bakiyesine rastgele sayilar atanarak basari ile olusturulmustur ve musteri hesaplarina eklenmiştir");
			Musteri.hesaplar.add(yatirim1);
		}	
			
		
		
		}
	
	void hesapSil(int tcKimlikNo,int musteriNumarasi,String ad,String soyad, String email, int telefonNumarasi) {
		//ilgili hesapta bakiye eğer 0 değilse hesap silinemez ve bunun için geri dönüt verilir
		
			if (VadeliHesap.toplamBakiye==0) {
				Musteri.hesaplar.remove(0); //ARRAY LİSTTEN KALDIRMA
				System.out.println("Hesap Baakiyesi 0 oldugu icin hesp silindi");
			}
			else if(VadesizHesap.toplamBakiye==0) {
				Musteri.hesaplar.remove(0);
				System.out.println("Hesap Baakiyesi 0 oldugu icin hesp silindi");
			}
			else if(YatirimHesap.toplamBakiye==0) {
				Musteri.hesaplar.remove(0);
				System.out.println("Hesap Baakiyesi 0 oldugu icin hesp silindi");
			}
			else {
				System.out.println("Silmek istediginiz hesabın bakiyesi 0 değil. Paranizi baska hesaba aktariniz");// geri dönüt
				System.out.println("Hesap Baakiyesi 0 oldugu icin hesp silindi");	
			}
		
	}

	public int getMusteriNumarasi() {
		return musteriNumarasi;
	}

	public void setMusteriNumarasi(int musteriNumarasi) {
		this.musteriNumarasi = musteriNumarasi;
	}

	
	
	//public to String {}
	
}



class KrediKarti{
	private int kartNumarasi;
	static double limit;
	static double guncelBorc;
	double kullanilabilirLimit;
	
	public KrediKarti(int kartNumarasi,double limit,double guncelBorc,double kullanilabilirLimit ){	
	this.kartNumarasi=kartNumarasi;
	this.limit=limit;
	this.guncelBorc=guncelBorc;
	this.kullanilabilirLimit=kullanilabilirLimit;
	
	}
	
	public void KrediKartEkle(int kartNumarasi,double limit,KrediKarti nesne) {	
		Musteri.krediKartlari.add(nesne); // kredi kartı müşreri sınıfındaki array liste ekleniyor
	}
	
	public void krediKartSil(int kartNumarasi,double limit,double guncelBorc,KrediKarti nesne){	
		this.limit=limit;
		this.guncelBorc=guncelBorc;
		if(guncelBorc!=0) 
			System.out.println("Lutfen oncelikle borc odemesi yapiniz"); // BORÇ SORGULAMASI YAPILIYOR
		else
			Musteri.krediKartlari.remove(nesne);
	}
	
	public double kullanilabilirLimit(int kartNumarasi,double guncelBorc){
		this.guncelBorc=guncelBorc;
		System.out.print("Kullanilabilir Limitiniz: ");
		return kullanilabilirLimit;
	}

	public int getKartNumarasi() {
		return kartNumarasi;
	}

	public void setKartNumarasi(int kartNumarasi) {
		this.kartNumarasi = kartNumarasi;
	}

	
			
}

class BankaHesap {
	static String hesapTuru;
	static int iban;
	Date hesapAcilisTarih;
	static double toplamBakiye;
	static String hesapBilgisi; //1:Maas,2:Normal
	double islemMiktar;
	

	public BankaHesap(int iban,int toplamBakiye,String hesapBilgisi) {	
		this.iban=iban;
		this.toplamBakiye=toplamBakiye;
		
		
	}
	
	public void hesapGoruntuleme(int musteriNumarasi,String ad,String soyad,long iban,double toplamBakiye,String hesapBilgisi) {
		
	}
	
	//public to String {}

}


class VadeliHesap extends BankaHesap{
	String hesapTuru;
	static double vadeliBakiye;
	float faizOrani;
	
	//Normal Hesap Faiz:%10
	//Maas Hesap Faiz: %20   
	public VadeliHesap(int iban,String hesapTuru,double vadeliBakiye,float faizOrani, int toplamBakiye, String hesapBilgisi){
		super(iban, toplamBakiye, hesapBilgisi);
		this.vadeliBakiye=vadeliBakiye;
		
	}
	
	//public to String {}
}

class VadesizHesap extends BankaHesap{
	String hesapTuru;
	static double vadesizBakiye;
	//Normal Kesinti: 8
	//Maas   Kesinti:0
	public VadesizHesap(int iban,String hesapTuru,double vadesizBakiye, int toplamBakiye, String hesapBilgisi) {
		super(iban, toplamBakiye, hesapBilgisi);
	}
	
	public double paraTransfer(String hesapTuru,long iban,double vadesizBakiye,int islemMiktar) {
		return 0;	
	}
	
	public double krediKartBorcOdeme(double vadesizBakiye,KrediKarti guncelBorc,double odenen){//BORÇ ODEMEDE İŞLEMLER PDF DE İSTENEN GİBİ GERÇEKLEŞTİRİLMEKTE
		vadesizBakiye=vadesizBakiye-odenen;
		KrediKarti.guncelBorc=KrediKarti.guncelBorc-odenen;
		
		
		return vadesizBakiye;	
	}
	
	public double krediOdeme(int krediID,Krediler krediMiktari,Krediler taksitMiktari,double odenen) {
		KrediKarti.guncelBorc=KrediKarti.guncelBorc-odenen;
		vadesizBakiye=vadesizBakiye-odenen;
		return vadesizBakiye;
	}
	//KREDİ ODEMEDE İŞLEMLER PDF DE İSTENEN GİBİ GERÇEKLEŞTİRİLMEKTE
	//public to String {}
}

class YatirimHesap extends BankaHesap {
	Scanner input = new Scanner(System.in);
	String hesapTuru;
	static double yatirimBakiye;
	String yatirimTuru;
	float kur;

	public YatirimHesap(float kur,String yatirimTuru,double yatirimBakiye,String hesapTuru,int iban, int toplamBakiye, String hesapBilgisi) {
		super(iban, toplamBakiye, hesapBilgisi);
		this.kur=kur;
		this.yatirimTuru=yatirimTuru;
		this.yatirimBakiye=yatirimBakiye;
		this.hesapTuru=hesapTuru;
		
		
	}
	
	public double paraEkle(double yatirimBakiye,String yatirimTuru,float kur) { //PARA EKLEME İŞLEMİ
		int a;
		System.out.println("Yatirilacak miktari giriniz: ");
		a=input.nextInt();
		this.yatirimBakiye=yatirimBakiye+a*kur;
		return 0;
	}
	
	public double paraBoz(double yatirimBakiye,String yatirimTuru,float kur) { //PARA BOZ İŞLEMİ
		int a;
		System.out.println("Bozulacak miktari giriniz: ");
		a=input.nextInt();
		this.yatirimBakiye=yatirimBakiye-a*kur;
		return 0;
	}
	
	//public to String {}	
}

class Krediler{
	private int krediID;
	static double krediMiktari=3000;
	static double taksitMiktar=8;
	
	public Krediler(int krediID,int musteriNumarasi,int krediMiktari) {
		this.krediID=krediID;
		
	
	}
	
	public void kampanya(int KrediKartilimit){
	}
	

	public int getKrediID() {
		return krediID;
	}

	public void setKrediID(int krediID) {
		this.krediID = krediID;
	}

	
}



public class Banka {
    public static void main(String[] args) {
    	Random rand=new Random();//Random syilar için gerekli
        Scanner scanner = new Scanner(System.in);
        BankaPersonel personel = null;
        Musteri musteri = null;

        while (true) { //SONSUZ DÖNGÜ
            System.out.println("Banka Uygulamasına Hoş Geldiniz!");
            System.out.println("1. Banka Personeli Girişi");
            System.out.println("2. Müşteri Girişi");
            System.out.println("3. Çıkış");
            System.out.println("4. KrediKarti limiti 5000 TL nin altinda olan Hesaplarin Borc miktarlari(Once Musteri Girisi sekmesinden Kart Ekleyiniz)");
            System.out.println("5. KrediKarti limiti 10000 TL nin uzerinde olan Hesaplar icin Kredi Teklif miktarlari(Once Musteri Girisi sekmesinden Kart Ekleyiniz)") ;  
            System.out.println("6. Musteri Numarasi ile Hesap bilgisi ogrenme (Bu islemi kullanmadan once lutfen ilk olarak Musteri girisi yapiniz)") ; 
            System.out.print("Seçiminizi yapın: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); // Boşluğu oku

            switch (secim) { //ANA SWİTCH
                case 1:
                    System.out.println("Personel Girişi");
                    System.out.print("TC Kimlik No:(5 hane) ");
                    int personelTcKimlikNo = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Ad: ");
                    String personelAd = scanner.nextLine();
                    System.out.print("Soyad: ");
                    String personelSoyad = scanner.nextLine();
                    System.out.print("Email: ");
                    String personelEmail = scanner.nextLine();
                    System.out.print("Telefon Numarası:(Basinda 0 olmadan 5 hane) ");
                    int personelTelefonNumarasi = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Personel ID:(5 hane) ");
                    int personelID = scanner.nextInt();
                    scanner.nextLine();

                    personel = new BankaPersonel(personelTcKimlikNo, personelAd, personelSoyad, personelEmail, personelTelefonNumarasi, personelID);
                    System.out.println("1. personel -personel- degiskeni ile kaydedildi.BİLGİLER:");
                    System.out.println("Ad:"+personel.getAd());
          			System.out.println("Soyad:"+personel.getSoyad());
          			System.out.println("TC:"+personel.getTcKimlikNo());
          			System.out.println("Email:"+personel.getEmail());
          			System.out.println("Tel:"+personel.getTelefonNumarasi());
          			System.out.println("Musteri No:"+personel.getPersonelID());
                    
                    System.out.println("Devam Ediliyor...");
                    System.out.println("Islem Seciniz:");
                	System.out.println("1)Personel Ekle\n2)Personel Sil");
                	int a = scanner.nextInt();
                	switch(a) {
                  	case 1://Personel girişi
                  		BankaPersonel personel2=new BankaPersonel(rand.nextInt(99999)+1,"Muhammed", "Doğru", "muhammed.dogru@gmail.com", rand.nextInt(99999)+1, rand.nextInt(99999)+1);
                  		System.out.println("2. Personel -musteri2- degiskeni ile kaydedildi.\nBilgiler:");
              			System.out.println("Ad:"+personel2.getAd());
              			System.out.println("Soyad:"+personel2.getSoyad());
              			System.out.println("TC:(Random)"+personel2.getTcKimlikNo());
              			System.out.println("Email:"+personel2.getEmail());
              			System.out.println("Tel:(Random)"+personel2.getTelefonNumarasi());
              			System.out.println("PersonelID:(Random)"+personel2.getPersonelID());
                  		
                  		break;
                  	case 2:
                  		System.out.println("1.Personel Başari ile silindi..");
                  		
                  		break;
                  	default:
                    	System.out.println("Tanimlanamayan islem numarasi");
                	}
                    break;
                                      
                case 2://Müşteri girişi       
                    System.out.println("Müşteri Girişi");
                    System.out.print("TC Kimlik No: (5 hane)");
                    int musteriTcKimlikNo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ad: ");
                    String musteriAd = scanner.nextLine();
                    System.out.print("Soyad: ");
                    String musteriSoyad = scanner.nextLine();
                    System.out.print("Email: ");
                    String musteriEmail = scanner.nextLine();
                    System.out.print("Telefon Numarası:(Basinda 0 olmadan 5 hane) ");
                    int musteriTelefonNumarasi = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Müşteri Numarası:(5 hane) ");
                    int musteriNumarasi = scanner.nextInt();
                    scanner.nextLine(); 
                    musteri = new Musteri(musteriTcKimlikNo, musteriAd, musteriSoyad, musteriEmail, musteriTelefonNumarasi, musteriNumarasi);
                    System.out.println("1. Musteri -musteri- degiskeni ile kaydedildi. Bilgiler:");
          			System.out.println("Ad:"+musteri.getAd());//MÜŞTERİ NESNESİ ÜZERİNDEN DEĞİŞKENLERE ERİŞİM
          			System.out.println("Soyad:"+musteri.getSoyad());
          			System.out.println("TC:"+musteri.getTcKimlikNo());
          			System.out.println("Email:"+musteri.getEmail());
          			System.out.println("Tel:"+musteri.getTelefonNumarasi());
          			System.out.println("Musteri No:"+musteri.getMusteriNumarasi());
                    System.out.println("Devam Ediliyor...");
                    System.out.println("Islem Seciniz:");
                	System.out.println("1)Musteri Ekle\n2)Hesap Ekle\n3)Hesap Sil(DİKKAT: Bir hesabı silmek için önce bir hesap olusturulmali!!)\n"
                			+ "4)Kredi Karti Ekle\n5)Kredi Karti Sil(DİKKAT: Bir karti silmek için önce bir kart olusturulmali!!)\n6)Hesaplarim\n7)Kartlarim\nGeri:0");
                	  int b = scanner.nextInt();
                	  switch(b) { //ARA SWİTCH YAPISI
                  	case 1:
                  			Musteri musteri2=new Musteri(rand.nextInt(99999)+1, "Mehmet", "Demirci", "demirci@demirci.com", rand.nextInt(100)+1, rand.nextInt(100)+1);
                  			System.out.println("2. Musteri -musteri2- degiskeni ile kaydedildi.\nBilgiler:");
                  			System.out.println("Ad:"+musteri2.getAd());
                  			System.out.println("Soyad:"+musteri2.getSoyad());
                  			System.out.println("TC:(Random)"+musteri2.getTcKimlikNo());
                  			System.out.println("Email:"+musteri2.getEmail());
                  			System.out.println("Tel:(Random)"+musteri2.getTelefonNumarasi());
                  			System.out.println("Musteri No:(Random)"+musteri2.getMusteriNumarasi());
                  		break;
                  	case 2:
                  		musteri.hesapEkle(musteri.getTcKimlikNo(), musteri.getMusteriNumarasi(),musteri.getAd(),musteri.getSoyad(),musteri.getEmail(), musteri.getTelefonNumarasi());
                  		System.out.println("1. musteri için Hesap oluşturuldu");
                 		break;
                  	case 3:
                  		musteri.hesapSil(musteri.getTcKimlikNo(), musteri.getMusteriNumarasi(), musteri.getAd(), musteri.getSoyad(),musteri.getEmail(),musteri.getTelefonNumarasi());                 	                 
                  		break;
                  		
                  	case 4://kart ekle
                  		KrediKarti kart1=new KrediKarti(rand.nextInt(100)+1, 4000,500, 1000);//KREDİ KARTI PARAMETRESİ AYARLAMA
                  		 //KrediKarti(int kartNumarasi,double limit,double guncelBorc,double kullanilabilirLimit )
                		kart1.KrediKartEkle(kart1.getKartNumarasi(), kart1.limit,kart1);
                		System.out.println("Kartınız -kart1- degiskeni ile olusturuldu\nBilgiler:");
                		System.out.println("Kart Numrasi:(Random)"+kart1.getKartNumarasi());
                		System.out.println("Limit: "+kart1.limit);
                		System.out.println("Guncel Borc:"+kart1.guncelBorc);
                		System.out.println("Kullanilabilir Limit:"+kart1.kullanilabilirLimit);
                		System.out.println("(Dilerseniz KrediKarti degiskenlerini 504. satirdan degistirebilirsiniz)");
                		
                  		break;
                  	case 5://kart sil
                  		KrediKarti kart2=new KrediKarti(rand.nextInt(100)+1, 2000,0, 1000);
                  		kart2.krediKartSil(kart2.getKartNumarasi(), kart2.limit, kart2.guncelBorc, kart2);
                  		break;
                  	case 6://hesaplar
                  		System.out.println(musteri.hesaplar);

                  		break;
                  	case 7://kartlar
                  		System.out.println(musteri.krediKartlari);
                  		break;
                  		
                  		default:
                  			System.out.println("Tanimlanamayan islem numarasi");
         
                  	}
                    
                    break;
                    
                    

                case 3:
                    System.out.println("Çıkış yapılıyor...");
                    System.out.println("Çıkış Yapildi");
                    System.out.println("Bizi tercih ettiginiz icin tesekkur eder yine bekleriz...");
                    return;
                case 4://Limiti 5000 den küçük hesaplar için borç gösterimi
                	if (KrediKarti.limit<5000) 
                		System.out.println(KrediKarti.guncelBorc);
                	else
                		System.out.println("Limiti 5000 Tl nin altinda bir Kredi Karti bulunmamakta(KrediKarti degiskenlerini 504. satirdan degistirebilirsiniz)");
                		
                	break;
                case 5://Limiti 10000 den buyuk hesaplar için kredi teklifi
                	if (KrediKarti.limit>10000) {
                		System.out.println("Kredi Karti limitiniz 10000 TL nin uzerinde. Asagidaki Kredi teklifini degerlendirebilirsiniz") ;               		
                		System.out.println("Toplam Bakiyenize Göre Kredi teklifimiz:"+Krediler.krediMiktari);
                		System.out.println("Taksit Miktari: "+Krediler.taksitMiktar);
                			
                	}
                	else
                		System.out.println("Limiti 10000 Tl nin uzerinde bir Kredi Karti bulunmamakta. Malesef Herhangi bir teklifimiz sizin için mecut değil (KrediKarti degiskenlerini 504. satirdan degistirebilirsiniz)");
                	
                    break;
                case 6:// Müşteri numarası ile giriş
                	System.out.println("Sisteme ilk giriste Olusturdugunuz Musterinin 5 haneli  musteri numarasini tuslayiniz lutfen");
                	int girilenNo = scanner.nextInt();
                	if(girilenNo==musteri.getMusteriNumarasi()) {
                		System.out.println("MUSTERI BILGILERİ");
                		System.out.println("Ad:"+musteri.getAd());
              			System.out.println("Soyad:"+musteri.getSoyad());
              			System.out.println("TC:"+musteri.getTcKimlikNo());
              			System.out.println("Email:"+musteri.getEmail());
              			System.out.println("Tel:"+musteri.getTelefonNumarasi());
              			System.out.println("Musteri No:"+musteri.getMusteriNumarasi());
              			System.out.println("Mevcut Hesaplar: "+musteri.hesaplar); 
              			System.out.println("Mevcut Kredi Kartlari: "+musteri.krediKartlari);
              			System.out.println("Toplam Bakiye: "+BankaHesap.toplamBakiye);
              			System.out.println("Banka Hesap Turu: "+musteri.hesapTuru);
              			}
                	else
                	System.out.println("Eksik ya da hatali tuslama yaptiniz. Sistemde boyle bir musteri numarasi mevcut degil");
                  
                    break;

                default:
                    System.out.println("Geçersiz seçim!");
                    break;
            }

            
            
            
        }
    }
}

=======
package BankaApp;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

class Kisi{
	private int tcKimlikNo;
	private String ad;
	private String soyad;
	private String email;
	private int telefonNumarasi;
	
	
	public Kisi(int tcKimlikNo,String ad,String soyad,String email,int telefonNumarasi) {
		this.setAd(ad); // YEREL DEĞİŞKENE THİS İLE PRAMETRELER AKTARİLİYOR.
		this.setSoyad(soyad);
		this.setEmail(email);
		this.setTelefonNumarasi(telefonNumarasi);
		this.setTcKimlikNo(tcKimlikNo);
	}
	


	public int getTcKimlikNo() { //private değişkenlere erişim için
		return tcKimlikNo;
	}


	public void setTcKimlikNo(int tcKimlikNo) { //private değişkenlere erişim için
		this.tcKimlikNo = tcKimlikNo;
	}


	public String getAd() {
		return ad;
	}


	public void setAd(String ad) {
		this.ad = ad;
	}


	public String getSoyad() {
		return soyad;
	}


	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getTelefonNumarasi() {
		return telefonNumarasi;
	}


	public void setTelefonNumarasi(int telefonNumarasi) {
		this.telefonNumarasi = telefonNumarasi;
	}


	

	
	//public to String {}
		
}

class BankaPersonel extends Kisi{
	private int personelID;
	ArrayList<Object> Musteriler = new ArrayList<>(); //Personel için array listler tanımlanmıştır
	public BankaPersonel(int tcKimlikNo,String ad, String soyad, String email, int telefonNumarasi, int personelID) {
		super(tcKimlikNo,ad, soyad, email, telefonNumarasi);
		this.personelID = personelID;
		
		 //System.out.println("PERSONELIN\nAd:"+ad+"\nSoyad:"+soyad+"\nTC:"+tcKimlikNo+"\nE-Mail:"+email+"\nTel:"+telefonNumarasi+"\nID:"+personelID); 
		 
	}
	public int getPersonelID() {
		return personelID;
	}

	public void setPersonelID(int personelID) {
		this.personelID = personelID;
	}


	
	
	//public to String {}
	
}

class Musteri extends Kisi{
	private int musteriNumarasi;
	static ArrayList<Object> hesaplar = new ArrayList<>(); //Musteri için hesaplar array listi
	static ArrayList<Object> krediKartlari = new ArrayList<>();//Musteri için kredi kartı array listi
	static ArrayList<Object> hesapTuru = new ArrayList<>(); //Musteri için hesap turu array listi
	
	public Musteri(int tcKimlikNo,String ad, String soyad, String email, int telefonNumarasi,int musteriNumarasi) {
		super(tcKimlikNo,ad, soyad, email, telefonNumarasi);
		this.setMusteriNumarasi(musteriNumarasi);
		//System.out.println("MUSTERININ\nAd:"+ad+"\nSoyad:"+soyad+"\nTC:"+tcKimlikNo+"\nE-Mail:"+email+"\nTel:"+telefonNumarasi+"\nID:"+musteriNumarasi);
		}
		
	void hesapEkle(int tcKimlikNo,int musteriNumarasi,String ad,String soyad, String email, int telefonNumarasi) { // Main fonksiyonundan hesap üretimi için hesap eklenin çağrılması yeterli
		int a;
		int b;
		String c;
		
		Random rand=new Random();
		Scanner input = new Scanner(System.in);
		System.out.println("\nAcmak istediginiz hesap turunu seciniz:\n1)Vadeli\n2)Vadesiz\n3)Yatırım\n--> ");
		a = input.nextInt();
		if (a==1) { // vadeli hesap kaydı işlemleri
			System.out.println("Vadeli hesabinizin Toplam Bakiyesini giriniz\n--> ");
			b = input.nextInt();
			System.out.println("Vadeli hesabinizinNe ne tur bir hesap olmasini istiyorsunuz Maas(1), Normal(2)\n--> ");
			c = input.next();
			Musteri.hesapTuru.add(c); //ARRAY LİSTE EKLEME YAPMA
			VadeliHesap vadeli1=new VadeliHesap(BankaHesap.iban,"Vadeli",rand.nextInt(2000)+1, 20, b,c);
			System.out.println("Vadeli hesbiniz, ibanina ve vadeli bakiyesine rastgele sayilar atanarak basari ile olusturulmustur ve musteri hesaplarina eklenmiştir");
			Musteri.hesaplar.add(vadeli1);
		}	
		
		else if(a==2) { //vadesiz hesap kaydı işlemleri
			System.out.println("Vadesiz hesabinizin Toplam Bakiyesini giriniz\n--> ");
			b = input.nextInt();
			System.out.println("Vadeli hesabinizinNe ne tur bir hesap olmasini istiyorsunuz Maas(1), Normal(2)\n--> ");
			c = input.next();
			Musteri.hesapTuru.add(c);
			VadesizHesap vadesiz1=new VadesizHesap(BankaHesap.iban, "Vadesiz", rand.nextInt(2000)+1, b, c);
			System.out.println("Vadeli hesbiniz, ibanina ve vadeli bakiyesine rastgele sayilar atanarak basari ile olusturulmustur ve musteri hesaplarina eklenmiştir");
			Musteri.hesaplar.add(vadesiz1);
		}
		else if(a==3) { // yatırım hesap kaydı işlemleri
			System.out.println("Yatirim hesabinizin Toplam Bakiyesini giriniz\n--> ");
			b = input.nextInt();
			System.out.println("Yatirim hesabinizinNe ne tur bir hesap olmasini istiyorsunuz Maas(1), Normal(2)\n--> ");
			c = input.next();
			Musteri.hesapTuru.add(c);
			YatirimHesap yatirim1=new YatirimHesap(19, "yatirmTuru: Bos", rand.nextInt(2000)+1,"Yatirim",BankaHesap.iban, b, c);
			System.out.println("Yatirim hesbiniz, ibanina ve vadeli bakiyesine rastgele sayilar atanarak basari ile olusturulmustur ve musteri hesaplarina eklenmiştir");
			Musteri.hesaplar.add(yatirim1);
		}	
			
		
		
		}
	
	void hesapSil(int tcKimlikNo,int musteriNumarasi,String ad,String soyad, String email, int telefonNumarasi) {
		//ilgili hesapta bakiye eğer 0 değilse hesap silinemez ve bunun için geri dönüt verilir
		
			if (VadeliHesap.toplamBakiye==0) {
				Musteri.hesaplar.remove(0); //ARRAY LİSTTEN KALDIRMA
				System.out.println("Hesap Baakiyesi 0 oldugu icin hesp silindi");
			}
			else if(VadesizHesap.toplamBakiye==0) {
				Musteri.hesaplar.remove(0);
				System.out.println("Hesap Baakiyesi 0 oldugu icin hesp silindi");
			}
			else if(YatirimHesap.toplamBakiye==0) {
				Musteri.hesaplar.remove(0);
				System.out.println("Hesap Baakiyesi 0 oldugu icin hesp silindi");
			}
			else {
				System.out.println("Silmek istediginiz hesabın bakiyesi 0 değil. Paranizi baska hesaba aktariniz");// geri dönüt
				System.out.println("Hesap Baakiyesi 0 oldugu icin hesp silindi");	
			}
		
	}

	public int getMusteriNumarasi() {
		return musteriNumarasi;
	}

	public void setMusteriNumarasi(int musteriNumarasi) {
		this.musteriNumarasi = musteriNumarasi;
	}

	
	
	//public to String {}
	
}



class KrediKarti{
	private int kartNumarasi;
	static double limit;
	static double guncelBorc;
	double kullanilabilirLimit;
	
	public KrediKarti(int kartNumarasi,double limit,double guncelBorc,double kullanilabilirLimit ){	
	this.kartNumarasi=kartNumarasi;
	this.limit=limit;
	this.guncelBorc=guncelBorc;
	this.kullanilabilirLimit=kullanilabilirLimit;
	
	}
	
	public void KrediKartEkle(int kartNumarasi,double limit,KrediKarti nesne) {	
		Musteri.krediKartlari.add(nesne); // kredi kartı müşreri sınıfındaki array liste ekleniyor
	}
	
	public void krediKartSil(int kartNumarasi,double limit,double guncelBorc,KrediKarti nesne){	
		this.limit=limit;
		this.guncelBorc=guncelBorc;
		if(guncelBorc!=0) 
			System.out.println("Lutfen oncelikle borc odemesi yapiniz"); // BORÇ SORGULAMASI YAPILIYOR
		else
			Musteri.krediKartlari.remove(nesne);
	}
	
	public double kullanilabilirLimit(int kartNumarasi,double guncelBorc){
		this.guncelBorc=guncelBorc;
		System.out.print("Kullanilabilir Limitiniz: ");
		return kullanilabilirLimit;
	}

	public int getKartNumarasi() {
		return kartNumarasi;
	}

	public void setKartNumarasi(int kartNumarasi) {
		this.kartNumarasi = kartNumarasi;
	}

	
			
}

class BankaHesap {
	static String hesapTuru;
	static int iban;
	Date hesapAcilisTarih;
	static double toplamBakiye;
	static String hesapBilgisi; //1:Maas,2:Normal
	double islemMiktar;
	

	public BankaHesap(int iban,int toplamBakiye,String hesapBilgisi) {	
		this.iban=iban;
		this.toplamBakiye=toplamBakiye;
		
		
	}
	
	public void hesapGoruntuleme(int musteriNumarasi,String ad,String soyad,long iban,double toplamBakiye,String hesapBilgisi) {
		
	}
	
	//public to String {}

}


class VadeliHesap extends BankaHesap{
	String hesapTuru;
	static double vadeliBakiye;
	float faizOrani;
	
	//Normal Hesap Faiz:%10
	//Maas Hesap Faiz: %20   
	public VadeliHesap(int iban,String hesapTuru,double vadeliBakiye,float faizOrani, int toplamBakiye, String hesapBilgisi){
		super(iban, toplamBakiye, hesapBilgisi);
		this.vadeliBakiye=vadeliBakiye;
		
	}
	
	//public to String {}
}

class VadesizHesap extends BankaHesap{
	String hesapTuru;
	static double vadesizBakiye;
	//Normal Kesinti: 8
	//Maas   Kesinti:0
	public VadesizHesap(int iban,String hesapTuru,double vadesizBakiye, int toplamBakiye, String hesapBilgisi) {
		super(iban, toplamBakiye, hesapBilgisi);
	}
	
	public double paraTransfer(String hesapTuru,long iban,double vadesizBakiye,int islemMiktar) {
		return 0;	
	}
	
	public double krediKartBorcOdeme(double vadesizBakiye,KrediKarti guncelBorc,double odenen){//BORÇ ODEMEDE İŞLEMLER PDF DE İSTENEN GİBİ GERÇEKLEŞTİRİLMEKTE
		vadesizBakiye=vadesizBakiye-odenen;
		KrediKarti.guncelBorc=KrediKarti.guncelBorc-odenen;
		
		
		return vadesizBakiye;	
	}
	
	public double krediOdeme(int krediID,Krediler krediMiktari,Krediler taksitMiktari,double odenen) {
		KrediKarti.guncelBorc=KrediKarti.guncelBorc-odenen;
		vadesizBakiye=vadesizBakiye-odenen;
		return vadesizBakiye;
	}
	//KREDİ ODEMEDE İŞLEMLER PDF DE İSTENEN GİBİ GERÇEKLEŞTİRİLMEKTE
	//public to String {}
}

class YatirimHesap extends BankaHesap {
	Scanner input = new Scanner(System.in);
	String hesapTuru;
	static double yatirimBakiye;
	String yatirimTuru;
	float kur;

	public YatirimHesap(float kur,String yatirimTuru,double yatirimBakiye,String hesapTuru,int iban, int toplamBakiye, String hesapBilgisi) {
		super(iban, toplamBakiye, hesapBilgisi);
		this.kur=kur;
		this.yatirimTuru=yatirimTuru;
		this.yatirimBakiye=yatirimBakiye;
		this.hesapTuru=hesapTuru;
		
		
	}
	
	public double paraEkle(double yatirimBakiye,String yatirimTuru,float kur) { //PARA EKLEME İŞLEMİ
		int a;
		System.out.println("Yatirilacak miktari giriniz: ");
		a=input.nextInt();
		this.yatirimBakiye=yatirimBakiye+a*kur;
		return 0;
	}
	
	public double paraBoz(double yatirimBakiye,String yatirimTuru,float kur) { //PARA BOZ İŞLEMİ
		int a;
		System.out.println("Bozulacak miktari giriniz: ");
		a=input.nextInt();
		this.yatirimBakiye=yatirimBakiye-a*kur;
		return 0;
	}
	
	//public to String {}	
}

class Krediler{
	private int krediID;
	static double krediMiktari=3000;
	static double taksitMiktar=8;
	
	public Krediler(int krediID,int musteriNumarasi,int krediMiktari) {
		this.krediID=krediID;
		
	
	}
	
	public void kampanya(int KrediKartilimit){
	}
	

	public int getKrediID() {
		return krediID;
	}

	public void setKrediID(int krediID) {
		this.krediID = krediID;
	}

	
}



public class Banka {
    public static void main(String[] args) {
    	Random rand=new Random();//Random syilar için gerekli
        Scanner scanner = new Scanner(System.in);
        BankaPersonel personel = null;
        Musteri musteri = null;

        while (true) { //SONSUZ DÖNGÜ
            System.out.println("Banka Uygulamasına Hoş Geldiniz!");
            System.out.println("1. Banka Personeli Girişi");
            System.out.println("2. Müşteri Girişi");
            System.out.println("3. Çıkış");
            System.out.println("4. KrediKarti limiti 5000 TL nin altinda olan Hesaplarin Borc miktarlari(Once Musteri Girisi sekmesinden Kart Ekleyiniz)");
            System.out.println("5. KrediKarti limiti 10000 TL nin uzerinde olan Hesaplar icin Kredi Teklif miktarlari(Once Musteri Girisi sekmesinden Kart Ekleyiniz)") ;  
            System.out.println("6. Musteri Numarasi ile Hesap bilgisi ogrenme (Bu islemi kullanmadan once lutfen ilk olarak Musteri girisi yapiniz)") ; 
            System.out.print("Seçiminizi yapın: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); // Boşluğu oku

            switch (secim) { //ANA SWİTCH
                case 1:
                    System.out.println("Personel Girişi");
                    System.out.print("TC Kimlik No:(5 hane) ");
                    int personelTcKimlikNo = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Ad: ");
                    String personelAd = scanner.nextLine();
                    System.out.print("Soyad: ");
                    String personelSoyad = scanner.nextLine();
                    System.out.print("Email: ");
                    String personelEmail = scanner.nextLine();
                    System.out.print("Telefon Numarası:(Basinda 0 olmadan 5 hane) ");
                    int personelTelefonNumarasi = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Personel ID:(5 hane) ");
                    int personelID = scanner.nextInt();
                    scanner.nextLine();

                    personel = new BankaPersonel(personelTcKimlikNo, personelAd, personelSoyad, personelEmail, personelTelefonNumarasi, personelID);
                    System.out.println("1. personel -personel- degiskeni ile kaydedildi.BİLGİLER:");
                    System.out.println("Ad:"+personel.getAd());
          			System.out.println("Soyad:"+personel.getSoyad());
          			System.out.println("TC:"+personel.getTcKimlikNo());
          			System.out.println("Email:"+personel.getEmail());
          			System.out.println("Tel:"+personel.getTelefonNumarasi());
          			System.out.println("Musteri No:"+personel.getPersonelID());
                    
                    System.out.println("Devam Ediliyor...");
                    System.out.println("Islem Seciniz:");
                	System.out.println("1)Personel Ekle\n2)Personel Sil");
                	int a = scanner.nextInt();
                	switch(a) {
                  	case 1://Personel girişi
                  		BankaPersonel personel2=new BankaPersonel(rand.nextInt(99999)+1,"Muhammed", "Doğru", "muhammed.dogru@gmail.com", rand.nextInt(99999)+1, rand.nextInt(99999)+1);
                  		System.out.println("2. Personel -musteri2- degiskeni ile kaydedildi.\nBilgiler:");
              			System.out.println("Ad:"+personel2.getAd());
              			System.out.println("Soyad:"+personel2.getSoyad());
              			System.out.println("TC:(Random)"+personel2.getTcKimlikNo());
              			System.out.println("Email:"+personel2.getEmail());
              			System.out.println("Tel:(Random)"+personel2.getTelefonNumarasi());
              			System.out.println("PersonelID:(Random)"+personel2.getPersonelID());
                  		
                  		break;
                  	case 2:
                  		System.out.println("1.Personel Başari ile silindi..");
                  		
                  		break;
                  	default:
                    	System.out.println("Tanimlanamayan islem numarasi");
                	}
                    break;
                                      
                case 2://Müşteri girişi       
                    System.out.println("Müşteri Girişi");
                    System.out.print("TC Kimlik No: (5 hane)");
                    int musteriTcKimlikNo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ad: ");
                    String musteriAd = scanner.nextLine();
                    System.out.print("Soyad: ");
                    String musteriSoyad = scanner.nextLine();
                    System.out.print("Email: ");
                    String musteriEmail = scanner.nextLine();
                    System.out.print("Telefon Numarası:(Basinda 0 olmadan 5 hane) ");
                    int musteriTelefonNumarasi = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Müşteri Numarası:(5 hane) ");
                    int musteriNumarasi = scanner.nextInt();
                    scanner.nextLine(); 
                    musteri = new Musteri(musteriTcKimlikNo, musteriAd, musteriSoyad, musteriEmail, musteriTelefonNumarasi, musteriNumarasi);
                    System.out.println("1. Musteri -musteri- degiskeni ile kaydedildi. Bilgiler:");
          			System.out.println("Ad:"+musteri.getAd());//MÜŞTERİ NESNESİ ÜZERİNDEN DEĞİŞKENLERE ERİŞİM
          			System.out.println("Soyad:"+musteri.getSoyad());
          			System.out.println("TC:"+musteri.getTcKimlikNo());
          			System.out.println("Email:"+musteri.getEmail());
          			System.out.println("Tel:"+musteri.getTelefonNumarasi());
          			System.out.println("Musteri No:"+musteri.getMusteriNumarasi());
                    System.out.println("Devam Ediliyor...");
                    System.out.println("Islem Seciniz:");
                	System.out.println("1)Musteri Ekle\n2)Hesap Ekle\n3)Hesap Sil(DİKKAT: Bir hesabı silmek için önce bir hesap olusturulmali!!)\n"
                			+ "4)Kredi Karti Ekle\n5)Kredi Karti Sil(DİKKAT: Bir karti silmek için önce bir kart olusturulmali!!)\n6)Hesaplarim\n7)Kartlarim\nGeri:0");
                	  int b = scanner.nextInt();
                	  switch(b) { //ARA SWİTCH YAPISI
                  	case 1:
                  			Musteri musteri2=new Musteri(rand.nextInt(99999)+1, "Mehmet", "Demirci", "demirci@demirci.com", rand.nextInt(100)+1, rand.nextInt(100)+1);
                  			System.out.println("2. Musteri -musteri2- degiskeni ile kaydedildi.\nBilgiler:");
                  			System.out.println("Ad:"+musteri2.getAd());
                  			System.out.println("Soyad:"+musteri2.getSoyad());
                  			System.out.println("TC:(Random)"+musteri2.getTcKimlikNo());
                  			System.out.println("Email:"+musteri2.getEmail());
                  			System.out.println("Tel:(Random)"+musteri2.getTelefonNumarasi());
                  			System.out.println("Musteri No:(Random)"+musteri2.getMusteriNumarasi());
                  		break;
                  	case 2:
                  		musteri.hesapEkle(musteri.getTcKimlikNo(), musteri.getMusteriNumarasi(),musteri.getAd(),musteri.getSoyad(),musteri.getEmail(), musteri.getTelefonNumarasi());
                  		System.out.println("1. musteri için Hesap oluşturuldu");
                 		break;
                  	case 3:
                  		musteri.hesapSil(musteri.getTcKimlikNo(), musteri.getMusteriNumarasi(), musteri.getAd(), musteri.getSoyad(),musteri.getEmail(),musteri.getTelefonNumarasi());                 	                 
                  		break;
                  		
                  	case 4://kart ekle
                  		KrediKarti kart1=new KrediKarti(rand.nextInt(100)+1, 4000,500, 1000);//KREDİ KARTI PARAMETRESİ AYARLAMA
                  		 //KrediKarti(int kartNumarasi,double limit,double guncelBorc,double kullanilabilirLimit )
                		kart1.KrediKartEkle(kart1.getKartNumarasi(), kart1.limit,kart1);
                		System.out.println("Kartınız -kart1- degiskeni ile olusturuldu\nBilgiler:");
                		System.out.println("Kart Numrasi:(Random)"+kart1.getKartNumarasi());
                		System.out.println("Limit: "+kart1.limit);
                		System.out.println("Guncel Borc:"+kart1.guncelBorc);
                		System.out.println("Kullanilabilir Limit:"+kart1.kullanilabilirLimit);
                		System.out.println("(Dilerseniz KrediKarti degiskenlerini 504. satirdan degistirebilirsiniz)");
                		
                  		break;
                  	case 5://kart sil
                  		KrediKarti kart2=new KrediKarti(rand.nextInt(100)+1, 2000,0, 1000);
                  		kart2.krediKartSil(kart2.getKartNumarasi(), kart2.limit, kart2.guncelBorc, kart2);
                  		break;
                  	case 6://hesaplar
                  		System.out.println(musteri.hesaplar);

                  		break;
                  	case 7://kartlar
                  		System.out.println(musteri.krediKartlari);
                  		break;
                  		
                  		default:
                  			System.out.println("Tanimlanamayan islem numarasi");
         
                  	}
                    
                    break;
                    
                    

                case 3:
                    System.out.println("Çıkış yapılıyor...");
                    System.out.println("Çıkış Yapildi");
                    System.out.println("Bizi tercih ettiginiz icin tesekkur eder yine bekleriz...");
                    return;
                case 4://Limiti 5000 den küçük hesaplar için borç gösterimi
                	if (KrediKarti.limit<5000) 
                		System.out.println(KrediKarti.guncelBorc);
                	else
                		System.out.println("Limiti 5000 Tl nin altinda bir Kredi Karti bulunmamakta(KrediKarti degiskenlerini 504. satirdan degistirebilirsiniz)");
                		
                	break;
                case 5://Limiti 10000 den buyuk hesaplar için kredi teklifi
                	if (KrediKarti.limit>10000) {
                		System.out.println("Kredi Karti limitiniz 10000 TL nin uzerinde. Asagidaki Kredi teklifini degerlendirebilirsiniz") ;               		
                		System.out.println("Toplam Bakiyenize Göre Kredi teklifimiz:"+Krediler.krediMiktari);
                		System.out.println("Taksit Miktari: "+Krediler.taksitMiktar);
                			
                	}
                	else
                		System.out.println("Limiti 10000 Tl nin uzerinde bir Kredi Karti bulunmamakta. Malesef Herhangi bir teklifimiz sizin için mecut değil (KrediKarti degiskenlerini 504. satirdan degistirebilirsiniz)");
                	
                    break;
                case 6:// Müşteri numarası ile giriş
                	System.out.println("Sisteme ilk giriste Olusturdugunuz Musterinin 5 haneli  musteri numarasini tuslayiniz lutfen");
                	int girilenNo = scanner.nextInt();
                	if(girilenNo==musteri.getMusteriNumarasi()) {
                		System.out.println("MUSTERI BILGILERİ");
                		System.out.println("Ad:"+musteri.getAd());
              			System.out.println("Soyad:"+musteri.getSoyad());
              			System.out.println("TC:"+musteri.getTcKimlikNo());
              			System.out.println("Email:"+musteri.getEmail());
              			System.out.println("Tel:"+musteri.getTelefonNumarasi());
              			System.out.println("Musteri No:"+musteri.getMusteriNumarasi());
              			System.out.println("Mevcut Hesaplar: "+musteri.hesaplar); 
              			System.out.println("Mevcut Kredi Kartlari: "+musteri.krediKartlari);
              			System.out.println("Toplam Bakiye: "+BankaHesap.toplamBakiye);
              			System.out.println("Banka Hesap Turu: "+musteri.hesapTuru);
              			}
                	else
                	System.out.println("Eksik ya da hatali tuslama yaptiniz. Sistemde boyle bir musteri numarasi mevcut degil");
                  
                    break;

                default:
                    System.out.println("Geçersiz seçim!");
                    break;
            }

            
            
            
        }
    }
}

>>>>>>> 316b2237957f8750628b8c163c5f113350b38830

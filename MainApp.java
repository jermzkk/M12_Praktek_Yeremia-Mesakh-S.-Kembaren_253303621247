public class MainApp {

    public static void main(String[] args) {

        HeroDAO dao = new HeroDAO();

        System.out.println("===== DATA AWAL =====");
        dao.ambilSemuaHero();

        System.out.println("\n===== UPDATE HERO =====");
        // Mengubah level hero dengan ID 1 menjadi 100
        dao.updateLevel(1, 100);

        System.out.println("\n===== DELETE HERO =====");
        // Menghapus hero dengan ID 2
        dao.hapusHero(3);

        System.out.println("\n===== DATA SETELAH UPDATE DAN DELETE =====");
        dao.ambilSemuaHero();
    }
}
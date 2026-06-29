import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HeroDAO {

    // Method Read: Mengambil dan menampilkan semua data hero dari database (Skenario READ)
    public void ambilSemuaHero() {
        String sql = "SELECT * FROM hero";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            System.out.println("ID\t| Nama Hero\t| Level");
            System.out.println("---------------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                int level = rs.getInt("level");
                System.out.println(id + "\t| " + nama + "\t\t| " + level);
            }
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan saat membaca data: " + e.getMessage());
        }
    }

    // Method Update: Mengubah level hero berdasarkan ID target
    public void updateLevel(int id_target, int level_baru) {
        String sql = "UPDATE hero SET level = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            // SYARAT MUTLAK: Penjelasan isi dari tanda tanya (?) menggunakan komentar //
            pst.setInt(1, level_baru); // ? indeks 1 diisi dengan nilai level_baru untuk SET level
            pst.setInt(2, id_target);  // ? indeks 2 diisi dengan ID target hero pada klausa WHERE id
            
            int rowsAffected = pst.executeUpdate(); // Eksekusi SQL Update
            
            if (rowsAffected > 0) {
                System.out.println("Berhasil! Level Hero dengan ID " + id_target + " telah diperbarui menjadi " + level_baru + ".");
            } else {
                System.out.println("Gagal! Hero dengan ID " + id_target + " tidak ditemukan.");
            }
            
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan database saat update level: " + e.getMessage());
        }
    }

    // Method Delete: Menghapus hero berdasarkan ID target
    public void hapusHero(int id_target) {
        String sql = "DELETE FROM hero WHERE id = ?";
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            // SYARAT MUTLAK: Penjelasan isi dari tanda tanya (?) menggunakan komentar //
            pst.setInt(1, id_target); // ? indeks 1 diisi dengan ID target hero yang akan dihapus pada WHERE id
            
            int rowsAffected = pst.executeUpdate(); // Eksekusi SQL Delete
            
            if (rowsAffected > 0) {
                System.out.println("Berhasil! Hero dengan ID " + id_target + " telah dihapus.");
            } else {
                System.out.println("Gagal! Hero dengan ID " + id_target + " tidak ditemukan.");
            }
            
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan database saat menghapus hero: " + e.getMessage());
        }
    }
}
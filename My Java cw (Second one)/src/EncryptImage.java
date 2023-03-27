
/*
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;


public class ImageCrypto extends javax.swing.JFrame {


    public ImageCrypto() {
        initComponents();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        file_path = new javax.swing.JTextField();
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();
        JButton jButton3 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Choose");
        jButton1.addActionListener(evt -> jButton1ActionPerformed());

        jButton2.setText("Encrypt");
        jButton2.addActionListener(evt -> jButton2ActionPerformed());

        jButton3.setText("Decrypt");
        jButton3.addActionListener(evt -> jButton3ActionPerformed());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(file_path, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(192, 192, 192)
                                                .addComponent(jButton2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton3)))
                                .addContainerGap(349, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(file_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addContainerGap(313, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed() {//GEN-FIRST:event_jButton1ActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        file_path.setText(f.getAbsolutePath());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed() {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            FileInputStream file = new FileInputStream(file_path.getText());
            FileOutputStream outStream = new FileOutputStream("Encrypt.jpg");
            byte[] k = "CooL2116NiTh5252".getBytes();
            SecretKeySpec key = new SecretKeySpec(k, "AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.ENCRYPT_MODE, key);
            CipherOutputStream cos = new CipherOutputStream(outStream, enc);
            byte[] buf = new byte[1024];
            int read;
            while ((read = file.read(buf)) != -1) {
                cos.write(buf, 0, read);
            }
            file.close();
            outStream.flush();
            cos.close();
            JOptionPane.showMessageDialog(null, "The file encrypted Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed() {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            FileInputStream file = new FileInputStream(file_path.getText());
            FileOutputStream outStream = new FileOutputStream("Decrypt.jpg");
            byte[] k = "CooL2116NiTh5252".getBytes();
            SecretKeySpec key = new SecretKeySpec(k, "AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.DECRYPT_MODE, key);
            CipherOutputStream cos = new CipherOutputStream(outStream, enc);
            byte[] buf = new byte[1024];
            int read;
            while ((read = file.read(buf)) != -1) {
                cos.write(buf, 0, read);
            }
            file.close();
            outStream.flush();
            cos.close();
            JOptionPane.showMessageDialog(null, "The image was decrypted successfully");
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "Decrypt.jpg");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException |
                 InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageCrypto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Create and display the form
        java.awt.EventQueue.invokeLater(() -> new ImageCrypto().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField file_path;
}

*/


import javax.crypto.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptImage {
    static int i = 0;
    static Cipher desCipher;
    static KeyGenerator keygenerator;
    static SecretKey myDesKey;

    public static byte[] encrypt(InputStream file) throws IOException {
        byte data[] = new byte[file.available()];
        file.read(data);
        int i = 0;

        for (byte b : data) {
            data[i] = (byte) (b ^ 123242);
            i++;
        }
        return data;
    }

    public static byte[] decrypt(FileInputStream file) throws IOException {
        byte data[] = new byte[file.available()];
        file.read(data);
        int i = 0;

        for (byte b : data) {
            data[i] = (byte) (b ^ 123242);
            i++;
        }
        return data;
    }

    public static byte[] StringEncrypt(String input) throws NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException {
        keygenerator = KeyGenerator.getInstance("DES");
        myDesKey = keygenerator.generateKey();
        desCipher = Cipher.getInstance("DES");
        byte[] text = input.getBytes("UTF8");
        desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
        byte[] textEncrypted = desCipher.doFinal(text);
        return textEncrypted;
    }

    public static byte[] decryptText(byte[] textEncrypted) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
        byte[] textDecrypted = desCipher.doFinal(textEncrypted);
        return textDecrypted;
    }
}

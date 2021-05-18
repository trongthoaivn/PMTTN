package REF;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64DecoderStream;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64EncoderStream;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class HashCode {


    public  SecretKey generateKey(String strkey) throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        String desKey = strkey;
        byte[] keyBytes = DatatypeConverter.parseHexBinary(desKey);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
        SecretKey key = factory.generateSecret(new DESKeySpec(keyBytes));
        return key;
    }

    public  String encrypt(String str, String strkey) {

        try {
            Cipher ecipher = Cipher.getInstance("DES");
            ecipher.init(Cipher.ENCRYPT_MODE, generateKey(strkey));
            byte[] utf8 = str.getBytes("UTF8");
            byte[] enc = ecipher.doFinal(utf8);
            enc = BASE64EncoderStream.encode(enc);
            return new String(enc);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public  String decrypt(String str, String strkey) {

        try {
            Cipher dcipher = Cipher.getInstance("DES");
            dcipher.init(Cipher.DECRYPT_MODE, generateKey(strkey));
            byte[] dec = BASE64DecoderStream.decode(str.getBytes());
            byte[] utf8 = dcipher.doFinal(dec);
            return new String(utf8, "UTF8");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}


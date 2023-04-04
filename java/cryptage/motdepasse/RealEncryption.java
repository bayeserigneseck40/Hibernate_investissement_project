package cryptage.motdepasse;




import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import models.Personne;

public class RealEncryption {
private Personne pers;
public RealEncryption(Personne pers){
this.pers=pers;
}
public void docry() {
class Crypt {
private void mypasscrypt() {
BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder ();
String hashedPassword = passwordEncoder.encode (pers.getPassword ( ));
pers.setPassword(hashedPassword);
}
}
new Crypt ( ) .mypasscrypt ( );
}
}

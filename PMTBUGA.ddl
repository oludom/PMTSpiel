ALTER TABLE Zeit modify column GemesseneZeit time(6);
ALTER TABLE benutzer_listedererrungenschaften DROP PRIMARY KEY;
ALTER TABLE Benutzer_listeDerErrungenschaften modify column ListeDerErrungenschaften varchar(255);
ALTER TABLE Benutzer_listeDerErrungenschaften ADD PRIMARY KEY(ListeDerErrungenschaften, BenutzerUsername);

package no.hvl.dat100.jplab12.oppgave3;


import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.Bilde;
import no.hvl.dat100.jplab12.oppgave2.Tekst;

public class Blogg {

	private Innlegg[] innleggstabell;
	private int nesteledig;

	public Blogg() {
		innleggstabell = new Innlegg[20];
		this.nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggstabell = new Innlegg[lengde];
		this.nesteledig = 0;
	}

	public int getAntall() {

		return this.nesteledig;
	}

	public Innlegg[] getSamling() {
		return innleggstabell;

	}

	public int finnInnlegg(Innlegg innlegg) {
		int finnes = -1;
		for (int i = 0; i < nesteledig && finnes == -1; i++) {
			if (innleggstabell[i] != null && innlegg.erLik(innleggstabell[i])) {
				finnes = i;

			}
		}
		return finnes;
	}

	public boolean finnes(Innlegg innlegg) {
		if (finnInnlegg(innlegg) != -1) {
			return true;
		}
		return false;
	}

	public boolean ledigPlass() {

		return (nesteledig < innleggstabell.length);

	}

	public boolean leggTil(Innlegg innlegg) {
		if (!finnes(innlegg) && ledigPlass()) {
			innleggstabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;

	}

	public String toString() {
		String str = nesteledig + "\n";
		for (int i = 0; i < nesteledig; i++) {
			
		if (innleggstabell[i] instanceof Bilde) {
			Bilde bildeObj = (Bilde) innleggstabell[i];
			str += bildeObj.toString();
		
		} else {
			Tekst tekstObj = (Tekst) innleggstabell[i];
			str += tekstObj.toString();
		}
		}
		return str;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());

	}

	public boolean slett(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}
}
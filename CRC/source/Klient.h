#include <exception>
using namespace std;

#ifndef __Klient_h__
#define __Klient_h__

// #include "Sklep.h"
// #include "Odwiedzajacy.h"
// #include "Produkt.h"

class Sklep;
class Odwiedzajacy;
class Produkt;
class Klient;

/**
 * osoba mog¹ca przegl¹daæ asortyment, kupowaæ oraz zwracaæ produkty.  
 */
class Klient
{
	private: string _produkt;
	private: string _sklep;
	private: string _wlasciciel;
	public: Sklep* _unnamed_Sklep_;
	public: Odwiedzajacy* _unnamed_Odwiedzaj¹cy_;
	public: Produkt* _unnamed_Produkt_;

	public: void przechowuje_informacje_o_zabiegach_wykonywanych_przez_osobe_kupujaca();
};

#endif

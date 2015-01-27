#include <exception>
using namespace std;

#ifndef __Produkt_h__
#define __Produkt_h__

// #include "Sklep.h"
// #include "Klient.h"
// #include "Wlasciciel.h"

class Sklep;
class Klient;
class Wlasciciel;
class Produkt;

/**
 * fizyczna rzecz, która mo¿na nabyæ
 */
class Produkt
{
	private: string _klient;
	private: string _sklep;
	private: string _w³aœciciel;
	public: Sklep* _unnamed_Sklep_;
	public: Klient* _unnamed_Klient_;
	public: Wlasciciel* _unnamed_W³aœciciel_;

	public: void przechowuje_informacje_o_produkcie();
};

#endif

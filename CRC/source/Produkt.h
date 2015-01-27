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
 * fizyczna rzecz, kt�ra mo�na naby�
 */
class Produkt
{
	private: string _klient;
	private: string _sklep;
	private: string _w�a�ciciel;
	public: Sklep* _unnamed_Sklep_;
	public: Klient* _unnamed_Klient_;
	public: Wlasciciel* _unnamed_W�a�ciciel_;

	public: void przechowuje_informacje_o_produkcie();
};

#endif

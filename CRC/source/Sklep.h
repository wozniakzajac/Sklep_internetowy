#include <exception>
using namespace std;

#ifndef __Sklep_h__
#define __Sklep_h__

// #include "Klient.h"
// #include "Produkt.h"
// #include "Wlasciciel.h"

class Klient;
class Produkt;
class Wlasciciel;
class Sklep;

/**
 * funkcja kupowania, nabywania
 */
class Sklep
{
	private: string _klient;
	private: string _produkt;
	private: string _w³aœciciel;
	public: Klient* _unnamed_Klient_;
	public: Produkt* _unnamed_Produkt_;
	public: Wlasciciel* _unnamed_Wlasciciel_;

	public: void przechowuje_informacje_o_dokonanych_zakupach();
};

#endif

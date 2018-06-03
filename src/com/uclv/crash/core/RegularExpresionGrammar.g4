/*
 * Copyright (C) 2018 Yasiel Cabrera Alonso
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

grammar RegularExpresionGrammar;

start   :
            exp+
        ;

exp     :
              exp ZERO_OR_MANY_OP                           #expAsterisk
            | exp ONE_OR_MANY_OP                            #expPlus
            | exp CONCAT_OP exp                             #expDot
            | exp OR_OP exp                                 #expOr
            | '(' exp+ ')'                                  #expBracket
            | TK_ID exp                                     #expManyIds
            | TK_ID                                         #expId
        ;

TK_ID   :   
            LETRA
            |DIGITO
        ;
//('\\+' | '\\-' | .)*?


fragment
LETRA   :  ('a'..'z'|'A'..'Z')
        ;

fragment
DIGITO      :  '0'..'9'
        ;

fragment
SYMBOL      :  
                '!'|'$'|'^'|'&'|'*'|'('|')'|'{'|'}'|'['|']'
                |'='|'-'|'_'|'+'|'|'|'.'|':'|';'|','|'?'
        ;

ZERO_OR_MANY_OP : '*' ;
ONE_OR_MANY_OP  : '+' ;
CONCAT_OP       : '.' ;
OR_OP           : '|' ;

WS      :
            (' '
            |'\t'
            |'\r'
            |'\n'
            )
            {skip();}
        ;
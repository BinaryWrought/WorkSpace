package core;

/**
 * This enum class represents all the possible negative status effects
 * 
 * @author jhazelle
 */
public enum Statuses 
{
    BLIND, BURNED, CONFUSED, SOAKED, DISABLED, PARALYZED, BOUND, PETRIFIED, SLEEP;
}

//Consider making at least one negative status effect for each element
// Light -> blind (low accuracy)
// Fire -> burned (fire damage over time - takes increased fire damage)
// Air -> confused (might attack itself)
// Water -> soaked (water damage over time - takes increased water damage)
// Neutral -> disabled (disallow one of the BMon's moves)
// Electric -> paralyzed (might not attack)
// Plant -> bound (plant damage over time - takes increased plant damage)
// Rock -> petrify ( cannot attack, also cannot take damage )
// Dark -> sleep (cannot attack - cured on damage
//AND consider making each status effect cured by some opposing element

//Currently with above list statuses fall into these types:
// 3 DOTs (each different element - and increase damage from that element)
// 1 cannot attack - cured on damage
// 1 cannot attack and does not take damage
// 1 might not attack
// 1 might attack self
// 1 low accuracy
// 1 can't use one move

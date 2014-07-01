package com.hashedin;

public class Genre {
	private boolean unknown;
	private boolean action;
	private boolean adventure;
	private boolean animation;
	private boolean children;
	private boolean comedy;
	private boolean crime;
	private boolean documentary;
	private boolean drama;
	private boolean fantasy;
	private boolean filmNoir;
	private boolean horror;
	private boolean musical;
	private boolean mystery;
	private boolean romance;
	private boolean sciFi;
	private boolean thriller;
	private boolean war;
	private boolean western;

	public boolean isUnknown() {
		return unknown;
	}

	public void setUnknown(boolean unknown) {
		this.unknown = unknown;
	}

	public boolean isAction() {
		return action;
	}

	public void setAction(boolean action) {
		this.action = action;
	}

	public boolean isAdventure() {
		return adventure;
	}

	public void setAdventure(boolean adventure) {
		this.adventure = adventure;
	}

	public boolean isAnimation() {
		return animation;
	}

	public void setAnimation(boolean animation) {
		this.animation = animation;
	}

	public boolean isChildren() {
		return children;
	}

	public void setChildren(boolean children) {
		this.children = children;
	}

	public boolean isComedy() {
		return comedy;
	}

	public void setComedy(boolean comedy) {
		this.comedy = comedy;
	}

	public boolean isCrime() {
		return crime;
	}

	public void setCrime(boolean crime) {
		this.crime = crime;
	}

	public boolean isDocumentary() {
		return documentary;
	}

	public void setDocumentary(boolean documentary) {
		this.documentary = documentary;
	}

	public boolean isDrama() {
		return drama;
	}

	public void setDrama(boolean drama) {
		this.drama = drama;
	}

	public boolean isFantasy() {
		return fantasy;
	}

	public void setFantasy(boolean fantasy) {
		this.fantasy = fantasy;
	}

	public boolean isFilmNoir() {
		return filmNoir;
	}

	public void setFilmNoir(boolean filmNoir) {
		this.filmNoir = filmNoir;
	}

	public boolean isHorror() {
		return horror;
	}

	public void setHorror(boolean horror) {
		this.horror = horror;
	}

	public boolean isMusical() {
		return musical;
	}

	public void setMusical(boolean musical) {
		this.musical = musical;
	}

	public boolean isMystery() {
		return mystery;
	}

	public void setMystery(boolean mystery) {
		this.mystery = mystery;
	}

	public boolean isRomance() {
		return romance;
	}

	public void setRomance(boolean romance) {
		this.romance = romance;
	}

	public boolean isSciFi() {
		return sciFi;
	}

	public void setSciFi(boolean sciFi) {
		this.sciFi = sciFi;
	}

	public boolean isThriller() {
		return thriller;
	}

	public void setThriller(boolean thriller) {
		this.thriller = thriller;
	}

	public boolean isWar() {
		return war;
	}

	public void setWar(boolean war) {
		this.war = war;
	}

	public boolean isWestern() {
		return western;
	}

	public void setWestern(boolean western) {
		this.western = western;
	}

	@Override
	public String toString() {
		return "Genre [unknown=" + unknown + ", action=" + action
				+ ", adventure=" + adventure + ", animation=" + animation
				+ ", children=" + children + ", comedy=" + comedy + ", crime="
				+ crime + ", documentary=" + documentary + ", drama=" + drama
				+ ", fantasy=" + fantasy + ", filmNoir=" + filmNoir
				+ ", horror=" + horror + ", musical=" + musical + ", mystery="
				+ mystery + ", romance=" + romance + ", sciFi=" + sciFi
				+ ", thriller=" + thriller + ", war=" + war + ", western="
				+ western + "]";
	}

}

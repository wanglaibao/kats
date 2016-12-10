package com.github.mttkay.kats.data.list

import com.github.mttkay.kats.Foldable


object ListFoldable : Foldable<ListContext.F> {

  override fun <A, B> foldLeft(fa: ListKind<A>, b: B, f: (B, A) -> B): B =
      fa.narrowList().list.fold(b, f)

  override fun <A, B> foldRight(fa: ListKind<A>, b: B, f: (A, B) -> B): B =
      fa.narrowList().list.foldRight(b, f)
}

fun <A, B> ListContext<A>.foldLeft(b: B, f: (B, A) -> B): B = ListFoldable.foldLeft(this, b, f)

fun <A, B> ListContext<A>.foldRight(b: B, f: (A, B) -> B): B = ListFoldable.foldRight(this, b, f)

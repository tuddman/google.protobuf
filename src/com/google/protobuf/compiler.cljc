;;;----------------------------------------------------------------------------------
;;; Generated by protoc-gen-clojure.  DO NOT EDIT
;;;
;;; Message Implementation of package com.google.protobuf.compiler
;;;----------------------------------------------------------------------------------
(ns com.google.protobuf.compiler
  (:require [protojure.protobuf.protocol :as pb]
            [protojure.protobuf.serdes.core :as serdes.core]
            [protojure.protobuf.serdes.complex :as serdes.complex]
            [protojure.protobuf.serdes.utils :refer [tag-map]]
            [protojure.protobuf.serdes.stream :as serdes.stream]
            [com.google.protobuf :as com.google.protobuf]
            [clojure.set :as set]
            [clojure.spec.alpha :as s]))

;;----------------------------------------------------------------------------------
;;----------------------------------------------------------------------------------
;; Forward declarations
;;----------------------------------------------------------------------------------
;;----------------------------------------------------------------------------------

(declare cis->Version)
(declare ecis->Version)
(declare new-Version)
(declare cis->CodeGeneratorRequest)
(declare ecis->CodeGeneratorRequest)
(declare new-CodeGeneratorRequest)
(declare cis->CodeGeneratorResponse)
(declare ecis->CodeGeneratorResponse)
(declare new-CodeGeneratorResponse)
(declare cis->CodeGeneratorResponse-File)
(declare ecis->CodeGeneratorResponse-File)
(declare new-CodeGeneratorResponse-File)


;;----------------------------------------------------------------------------------
;;----------------------------------------------------------------------------------
;; Message Implementations
;;----------------------------------------------------------------------------------
;;----------------------------------------------------------------------------------

;-----------------------------------------------------------------------------
; Version
;-----------------------------------------------------------------------------
(defrecord Version-protojure-type [major minor patch suffix]
  pb/Writer

  (serialize [this os]
    (serdes.core/write-Int32 1  {:optimize true} (:major this) os)
    (serdes.core/write-Int32 2  {:optimize true} (:minor this) os)
    (serdes.core/write-Int32 3  {:optimize true} (:patch this) os)
    (serdes.core/write-String 4  {:optimize true} (:suffix this) os)))

(s/def :com.google.protobuf.compiler.Version/major int?)
(s/def :com.google.protobuf.compiler.Version/minor int?)
(s/def :com.google.protobuf.compiler.Version/patch int?)
(s/def :com.google.protobuf.compiler.Version/suffix string?)
(s/def ::Version-spec (s/keys :opt-un [:com.google.protobuf.compiler.Version/major :com.google.protobuf.compiler.Version/minor :com.google.protobuf.compiler.Version/patch :com.google.protobuf.compiler.Version/suffix ]))
(def Version-defaults {:major 0 :minor 0 :patch 0 :suffix "" })

(defn cis->Version
  "CodedInputStream to Version"
  [is]
  (->> (tag-map Version-defaults
         (fn [tag index]
             (case index
               1 [:major (serdes.core/cis->Int32 is)]
               2 [:minor (serdes.core/cis->Int32 is)]
               3 [:patch (serdes.core/cis->Int32 is)]
               4 [:suffix (serdes.core/cis->String is)]

               [index (serdes.core/cis->undefined tag is)]))
         is)
        (map->Version-protojure-type)))

(defn ecis->Version
  "Embedded CodedInputStream to Version"
  [is]
  (serdes.core/cis->embedded cis->Version is))

(defn new-Version
  "Creates a new instance from a map, similar to map->Version except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::Version-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::Version-spec init))))]}
  (-> (merge Version-defaults init)
      (map->Version-protojure-type)))

(defn pb->Version
  "Protobuf to Version"
  [input]
  (cis->Version (serdes.stream/new-cis input)))

;-----------------------------------------------------------------------------
; CodeGeneratorRequest
;-----------------------------------------------------------------------------
(defrecord CodeGeneratorRequest-protojure-type [file-to-generate parameter proto-file compiler-version]
  pb/Writer

  (serialize [this os]
    (serdes.complex/write-repeated serdes.core/write-String 1 (:file-to-generate this) os)
    (serdes.core/write-String 2  {:optimize true} (:parameter this) os)
    (serdes.complex/write-repeated serdes.core/write-embedded 15 (:proto-file this) os)
    (serdes.core/write-embedded 3 (:compiler-version this) os)))

(s/def :com.google.protobuf.compiler.CodeGeneratorRequest/file-to-generate (s/every string?))
(s/def :com.google.protobuf.compiler.CodeGeneratorRequest/parameter string?)


(s/def ::CodeGeneratorRequest-spec (s/keys :opt-un [:com.google.protobuf.compiler.CodeGeneratorRequest/file-to-generate :com.google.protobuf.compiler.CodeGeneratorRequest/parameter ]))
(def CodeGeneratorRequest-defaults {:file-to-generate [] :parameter "" :proto-file [] })

(defn cis->CodeGeneratorRequest
  "CodedInputStream to CodeGeneratorRequest"
  [is]
  (->> (tag-map CodeGeneratorRequest-defaults
         (fn [tag index]
             (case index
               1 [:file-to-generate (serdes.complex/cis->repeated serdes.core/cis->String is)]
               2 [:parameter (serdes.core/cis->String is)]
               15 [:proto-file (serdes.complex/cis->repeated com.google.protobuf/ecis->FileDescriptorProto is)]
               3 [:compiler-version (ecis->Version is)]

               [index (serdes.core/cis->undefined tag is)]))
         is)
        (map->CodeGeneratorRequest-protojure-type)))

(defn ecis->CodeGeneratorRequest
  "Embedded CodedInputStream to CodeGeneratorRequest"
  [is]
  (serdes.core/cis->embedded cis->CodeGeneratorRequest is))

(defn new-CodeGeneratorRequest
  "Creates a new instance from a map, similar to map->CodeGeneratorRequest except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::CodeGeneratorRequest-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::CodeGeneratorRequest-spec init))))]}
  (-> (merge CodeGeneratorRequest-defaults init)
      (cond-> (contains? init :proto-file) (update :proto-file #(map com.google.protobuf/new-FileDescriptorProto %)))
      (cond-> (contains? init :compiler-version) (update :compiler-version new-Version))
      (map->CodeGeneratorRequest-protojure-type)))

(defn pb->CodeGeneratorRequest
  "Protobuf to CodeGeneratorRequest"
  [input]
  (cis->CodeGeneratorRequest (serdes.stream/new-cis input)))

;-----------------------------------------------------------------------------
; CodeGeneratorResponse
;-----------------------------------------------------------------------------
(defrecord CodeGeneratorResponse-protojure-type [error file]
  pb/Writer

  (serialize [this os]
    (serdes.core/write-String 1  {:optimize true} (:error this) os)
    (serdes.complex/write-repeated serdes.core/write-embedded 15 (:file this) os)))

(s/def :com.google.protobuf.compiler.CodeGeneratorResponse/error string?)

(s/def ::CodeGeneratorResponse-spec (s/keys :opt-un [:com.google.protobuf.compiler.CodeGeneratorResponse/error ]))
(def CodeGeneratorResponse-defaults {:error "" :file [] })

(defn cis->CodeGeneratorResponse
  "CodedInputStream to CodeGeneratorResponse"
  [is]
  (->> (tag-map CodeGeneratorResponse-defaults
         (fn [tag index]
             (case index
               1 [:error (serdes.core/cis->String is)]
               15 [:file (serdes.complex/cis->repeated ecis->CodeGeneratorResponse-File is)]

               [index (serdes.core/cis->undefined tag is)]))
         is)
        (map->CodeGeneratorResponse-protojure-type)))

(defn ecis->CodeGeneratorResponse
  "Embedded CodedInputStream to CodeGeneratorResponse"
  [is]
  (serdes.core/cis->embedded cis->CodeGeneratorResponse is))

(defn new-CodeGeneratorResponse
  "Creates a new instance from a map, similar to map->CodeGeneratorResponse except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::CodeGeneratorResponse-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::CodeGeneratorResponse-spec init))))]}
  (-> (merge CodeGeneratorResponse-defaults init)
      (cond-> (contains? init :file) (update :file #(map new-CodeGeneratorResponse-File %)))
      (map->CodeGeneratorResponse-protojure-type)))

(defn pb->CodeGeneratorResponse
  "Protobuf to CodeGeneratorResponse"
  [input]
  (cis->CodeGeneratorResponse (serdes.stream/new-cis input)))

;-----------------------------------------------------------------------------
; CodeGeneratorResponse-File
;-----------------------------------------------------------------------------
(defrecord CodeGeneratorResponse-File-protojure-type [name insertion-point content]
  pb/Writer

  (serialize [this os]
    (serdes.core/write-String 1  {:optimize true} (:name this) os)
    (serdes.core/write-String 2  {:optimize true} (:insertion-point this) os)
    (serdes.core/write-String 15  {:optimize true} (:content this) os)))

(s/def :com.google.protobuf.compiler.CodeGeneratorResponse-File/name string?)
(s/def :com.google.protobuf.compiler.CodeGeneratorResponse-File/insertion-point string?)
(s/def :com.google.protobuf.compiler.CodeGeneratorResponse-File/content string?)
(s/def ::CodeGeneratorResponse-File-spec (s/keys :opt-un [:com.google.protobuf.compiler.CodeGeneratorResponse-File/name :com.google.protobuf.compiler.CodeGeneratorResponse-File/insertion-point :com.google.protobuf.compiler.CodeGeneratorResponse-File/content ]))
(def CodeGeneratorResponse-File-defaults {:name "" :insertion-point "" :content "" })

(defn cis->CodeGeneratorResponse-File
  "CodedInputStream to CodeGeneratorResponse-File"
  [is]
  (->> (tag-map CodeGeneratorResponse-File-defaults
         (fn [tag index]
             (case index
               1 [:name (serdes.core/cis->String is)]
               2 [:insertion-point (serdes.core/cis->String is)]
               15 [:content (serdes.core/cis->String is)]

               [index (serdes.core/cis->undefined tag is)]))
         is)
        (map->CodeGeneratorResponse-File-protojure-type)))

(defn ecis->CodeGeneratorResponse-File
  "Embedded CodedInputStream to CodeGeneratorResponse-File"
  [is]
  (serdes.core/cis->embedded cis->CodeGeneratorResponse-File is))

(defn new-CodeGeneratorResponse-File
  "Creates a new instance from a map, similar to map->CodeGeneratorResponse-File except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::CodeGeneratorResponse-File-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::CodeGeneratorResponse-File-spec init))))]}
  (-> (merge CodeGeneratorResponse-File-defaults init)
      (map->CodeGeneratorResponse-File-protojure-type)))

(defn pb->CodeGeneratorResponse-File
  "Protobuf to CodeGeneratorResponse-File"
  [input]
  (cis->CodeGeneratorResponse-File (serdes.stream/new-cis input)))

